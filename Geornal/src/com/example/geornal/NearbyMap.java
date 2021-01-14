package com.example.geornal;

import java.util.ArrayList;
import java.util.Random;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NearbyMap extends Activity{
	
	private GoogleMap map;
	Button setMapPinButton, postButton;
	Random rn;
	
	LatLngBounds bounds;
	BitmapDescriptor image;
	MarkerOptions marker;
	
	static int markerCount = 0;
	boolean markerContents = false;
	
	private LatLng LOCATION_TORONTO = new LatLng(43.652073, -79.382293);
	
	ArrayList<View> viewArrayList = new ArrayList<View>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nearby_map);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		setMapPinButton = (Button) findViewById(R.id.bSetMapPin);
		postButton = (Button) findViewById(R.id.bPost);
		
		rn = new Random();
		
	//	String ss = getResources().getString(R.string.CLIENT_ID);
		
		image = BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
		bounds = map.getProjection().getVisibleRegion().latLngBounds;
		
		map.setInfoWindowAdapter(new InfoWindowAdapter() {
			
	        // Use default InfoWindow frame
	        @Override
	        public View getInfoWindow(Marker arg0) {
	            return null;
	        }

	        // Defines the contents of the InfoWindow
	        @Override
	        public View getInfoContents(Marker arg0) {

	            // Getting view from the layout file info_window_layout
	            View v = getLayoutInflater().inflate(R.layout.windowlayout, null);

	            // Getting the position from the marker
	            LatLng latLng = arg0.getPosition();

	            // Getting reference to the TextView to set latitude
	            TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);

	            // Getting reference to the TextView to set longitude
	            TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);
	            
	            ImageView ivImage = (ImageView) v.findViewById(R.id.iv_image);

	            // Setting the latitude
	            tvLat.setText("Latitude:" + latLng.latitude);

	            // Setting the longitude
	            tvLng.setText("Longitude:"+ latLng.longitude);
	            
	            ivImage.setImageResource(R.drawable.ic_launcher);
	            
	            viewArrayList.add(v);
	            
	            // Returning the view containing InfoWindow contents
	            return v;

	        }
	    });
		
		map.setOnMapClickListener(new OnMapClickListener() {

	        @Override
	        public void onMapClick(LatLng arg0) {
	            // Clears any existing markers from the GoogleMap
	            //map.clear();

	            // Creating an instance of MarkerOptions to set position
	            MarkerOptions markerOptions = new MarkerOptions();

	            // Setting position on the MarkerOptions
	            markerOptions.position(arg0);

	            // Animating to the currently touched position
	            map.animateCamera(CameraUpdateFactory.newLatLng(arg0));
	            
	            // Adding marker on the GoogleMap
	            Marker marker = map.addMarker(markerOptions);
	            
	            marker.setTitle("" + markerCount);
	            markerCount++;
	            
	            // Showing InfoWindow on the GoogleMap
	            marker.showInfoWindow(); 

	        }
	       
	    });
		
		setMapPinButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
			//	CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_TORONTO);
			//	map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				/** zoom levels 0-21, 0 is world and 21 most zoomed */
				CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_TORONTO, 14);
				map.animateCamera(update);
				map.addMarker(new MarkerOptions().position(LOCATION_TORONTO).title("TORONTO!!!"));
				
			//	GroundOverlay groundOverlay = map.addGroundOverlay(new GroundOverlayOptions().image(image).positionFromBounds(bounds).transparency((float) 0.1));
				
				GroundOverlayOptions groundOverlay = new GroundOverlayOptions().image(image).position(LOCATION_TORONTO, 500f, 500f).transparency(0.1f);
			//	map.addGroundOverlay(groundOverlay);
				
				marker = new MarkerOptions().position(LOCATION_TORONTO).title("Hello Toronto!");
				marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
			//	map.addMarker(marker);
				
				//update location
				double randLat, randLng;
				int randNum1 = rn.nextInt(5) + 1;
				int randNum2 = rn.nextInt(5) + 1;
				int mod = randNum1 % 2;
				if(mod == 1) {
					randLat = 43.65 + 0.01*randNum1;
					randLng = -79.38 + 0.01*randNum2;
					Log.i("nearby", "mod==" + mod + " randLat: " + randLat + " | randLng: " + randLng);
				}else{
					randLat = 43.65 - 0.01*randNum1;
					randLng = -79.38 - 0.01*randNum2;
					Log.i("nearby", "mod==" + mod + " randLat: " + randLat + " | randLng: " + randLng);
				}
				
				LOCATION_TORONTO = new LatLng(randLat, randLng);
			}

		});
		
		postButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Class<?> ourClass;
					ourClass = Class.forName("com.example.geornal.PostScreen");
					Intent ourIntent = new Intent(NearbyMap.this, ourClass);
					startActivity(ourIntent);
					
				} catch (ClassNotFoundException e) {
					Log.i("nearby", "Failed starting PostScreen.java");
				}
				
			}
		});
		
		
		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

	        @Override
	        public void onInfoWindowClick(Marker marker) {
	        	
	            marker.hideInfoWindow();   
	            
	            try {
					Class<?> ourClass;
					ourClass = Class.forName("com.example.geornal.PostScreen");
					Intent ourIntent = new Intent(NearbyMap.this, ourClass);
					startActivity(ourIntent);
					
				} catch (ClassNotFoundException e) {
					Log.i("nearby", "Failed starting PostScreen.java");
				}
	            
	        }
	    });
		
		map.setOnMapLongClickListener(new OnMapLongClickListener() {

			@Override
			public void onMapLongClick(LatLng point) {
				
				
			}
		});
		
		map.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker marker) {
				
				marker.setDraggable(true);
				LatLng newPosition = marker.getPosition();
				
				
				
				return false;
			}
			
		});
		
		map.setOnMarkerDragListener(new OnMarkerDragListener() {

			@Override
			public void onMarkerDrag(Marker marker) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onMarkerDragEnd(Marker marker) {
				// TODO Auto-generated method stub
				int count = Integer.parseInt(marker.getTitle());
				
			}

			@Override
			public void onMarkerDragStart(Marker marker) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
	}
	
	
}
