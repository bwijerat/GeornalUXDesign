package com.example.geornal;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ListRowLayoutArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final String[] values;
	  private static int count = 0;

	  public ListRowLayoutArrayAdapter(Context context, String[] values) {
	    super(context, R.layout.list_row_layout, values);
	    this.context = context;
	    this.values = values;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    
	    View rowView = inflater.inflate(R.layout.list_row_layout, parent, false);
	    
	    LinearLayout linearLayout = (LinearLayout) rowView.findViewById(R.id.linearlayout_list_row_layout);
	    TextView textView = (TextView) rowView.findViewById(R.id.list_label);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.list_icon);
	    
	    textView.setText(values[position]);
	    imageView.setImageResource(R.drawable.white_circle);
	    
	    if((count % 2) == 0){
	    	linearLayout.setBackgroundColor(Color.parseColor("#FE7C48"));
	    	count++;
	    }else{
	    	linearLayout.setBackgroundColor(Color.parseColor("#C67246"));
	    	count++;
	    }  
	    
	    return rowView;
	  }
	} 

