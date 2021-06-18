package com.example.dictinarycollegeproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class AptitudeActivity3 extends Activity {

	Button btnokandnext;
	RadioGroup rgb;
	String str="0",str1;
	int a,b,c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aptitude_activity3);

		btnokandnext = (Button) findViewById(R.id.button1);
		rgb = (RadioGroup) findViewById(R.id.radioGroup1);
	Intent in = getIntent();
	str1 = in.getStringExtra("k1");
	a = Integer.parseInt(str1);
		rgb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				switch (arg1) {
				case R.id.radio0:
					//str = "0";
					break;

	case R.id.radio1:
		//str = "0";
					break;
	case R.id.radio2:
		//str = "0";
		break;
	case R.id.radioButton1:
		str = "1";
		break;
				}
				
			}
		});
		btnokandnext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b = Integer.parseInt(str);
				c = a+b;
				str = String.valueOf(c);
				Intent in = new Intent(AptitudeActivity3.this,AptitudeActivity4.class);
				in.putExtra("k1",str);
				startActivity(in);
				finish();
			}
		});
		
	
	}
//19 D
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_aptitude_activity3, menu);
		return true;
	}

}
