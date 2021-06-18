package com.example.dictinarycollegeproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {

	Intent in;
	String str1,str2;
	int a;
	TextView tv2,tv3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        
        Intent in = getIntent();
        str1 = in.getStringExtra("k1");
        
        tv2.setText(str1+" out of 5 ");
        a = Integer.parseInt(str1);
        
        if(a==1)
        {
        	str2 = "Hmm you can do better than this better luck next time";
        	
        }
        if(a==2)
        {
        	str2 = "nice try better luck next time";
        	
        }
        if(a==3)
        {
        	str2 = "Good Keep it up";
        	
        }
        if(a==4)
        {
        	str2 = "So close to become the marvellous";
        	
        }
        if(a==5)
        {
        	str2 = "Excellent performance you are a genius";
        	
        }
        tv3.setText(str2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

}
