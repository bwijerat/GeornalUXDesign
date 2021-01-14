package com.example.geornal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Tab2Activity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entries_map);
		
		Log.v("list", "INSIDE Tab2Activity");
	}

}
