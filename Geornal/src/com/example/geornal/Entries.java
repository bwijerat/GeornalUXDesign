package com.example.geornal;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Entries extends TabActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entries);
		
		// create the TabHost that will contain the Tabs
        final TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        
       // Set the Tab name and Activity
       // that will be opened when particular Tab will be selected
        tab1.setIndicator("List");
        tab1.setContent(new Intent(this,Tab1Activity.class));
        
        tab2.setIndicator("Map");
        tab2.setContent(new Intent(this,Tab2Activity.class));
        
        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        
        TextView tv;
        
        tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#F2F2F2"));
        tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#797979"));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        
        tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#C9C9C9"));
        tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#797979"));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {

            public void onTabChanged(String tabId) {
            	
            	TextView tv;
            	
                switch (tabHost.getCurrentTab()) {
                case 0:
                	tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#F2F2F2"));
                    tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title);
                    tv.setTextColor(Color.parseColor("#797979"));
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    
                    tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#C9C9C9"));
                    tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title);
                    tv.setTextColor(Color.parseColor("#797979"));
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    
                    break;
                case 1:
                	tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#C9C9C9"));
                	tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title);
                    tv.setTextColor(Color.parseColor("#797979"));
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    
                    tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#F2F2F2"));
                    tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title);
                    tv.setTextColor(Color.parseColor("#797979"));
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    
                    break;

                default:
                    
                	break;
                }
            }
        });
		
	}
	
	
}
