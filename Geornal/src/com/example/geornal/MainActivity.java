package com.example.geornal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{
	
	Button profileButton, nearbyButton, tellMeAboutItButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		profileButton = (Button) findViewById(R.id.bProfile);
		nearbyButton = (Button) findViewById(R.id.bNearby);
		tellMeAboutItButton = (Button) findViewById(R.id.bTellMeAboutIt);
		
		
		profileButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Class<?> ourClass;
					ourClass = Class.forName("com.example.geornal.Profile");
					Intent ourIntent = new Intent(MainActivity.this, ourClass);
					startActivity(ourIntent);
					
				} catch (ClassNotFoundException e) {
					Log.i("nearby", "Failed starting Profile.java");
				}
				
			}

		});  
		
		nearbyButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Class<?> ourClass;
					ourClass = Class.forName("com.example.geornal.NearbyMap");
					Intent ourIntent = new Intent(MainActivity.this, ourClass);
					startActivity(ourIntent);
					
				} catch (ClassNotFoundException e) {
					Log.i("nearby", "Failed starting NearbyMap.java");
				}
			}

		});
		
		tellMeAboutItButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) { /*
				try {
					Class<?> ourClass;
					ourClass = Class.forName("com.example.geornal.TellMeAboutIt");
					Intent ourIntent = new Intent(MainActivity.this, ourClass);
					startActivity(ourIntent);
					
				} catch (ClassNotFoundException e) {
					Log.i("nearby", "Failed starting TellMeAboutIt.java: tellMeAboutItButton click");
				} */
			}

		});
		
	}

}
