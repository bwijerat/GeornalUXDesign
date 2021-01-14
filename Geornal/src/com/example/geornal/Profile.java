package com.example.geornal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Profile extends Activity{
	
	Button entriesButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		entriesButton = (Button) findViewById(R.id.bEntries);
		
		entriesButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Log.v("list", "BEFORE ArrayList");
					Class<?> ourClass;
					ourClass = Class.forName("com.example.geornal.Entries");
					Intent ourIntent = new Intent(Profile.this, ourClass);
					startActivity(ourIntent);
					
				} catch (ClassNotFoundException e) {
					Log.i("list", "Failed starting Profile.java");
				}
			}
		});
	}
	
	
}
