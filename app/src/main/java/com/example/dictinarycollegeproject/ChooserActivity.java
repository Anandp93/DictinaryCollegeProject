package com.example.dictinarycollegeproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChooserActivity extends Activity {

	ImageView imgButtondict,imgbButtonapti;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chooser);
		imgButtondict = (ImageView) findViewById(R.id.imageView1);
		imgbButtonapti = (ImageView) findViewById(R.id.imageView2);
		imgButtondict.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent in = new Intent(ChooserActivity.this,MainActivity.class);
				startActivity(in);
			}
		});
		
		imgbButtonapti.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(ChooserActivity.this,AptitudeActivity1.class);
				startActivity(in);
			}
		});
	}


}
