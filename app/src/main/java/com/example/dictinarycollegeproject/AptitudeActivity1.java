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

public class AptitudeActivity1 extends Activity {

Button btnokandnext;
RadioGroup rgb;
String str="0",str1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aptitude_activity1);
		
		btnokandnext = (Button) findViewById(R.id.button1);
		rgb = (RadioGroup) findViewById(R.id.radioGroup1);
		//Intent in = getIntent();
		//str1 = in.getStringExtra("k1");
		
		
		rgb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				switch (arg1) {
				case R.id.radio0:
					str="1";
					break;

	case R.id.radio1:
					str="0";
					break;
	case R.id.radio2:
		str="0";
		break;
	case R.id.radioButton1:
		str="0";
		break;
				}
				
			}
		});
		btnokandnext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(AptitudeActivity1.this,AptitudeActivity2.class);
				
				in.putExtra("k1",str);
				
				startActivity(in);
				finish();
				
			}
		});
		
	}
//6.25

}
