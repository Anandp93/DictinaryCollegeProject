package com.example.dictinarycollegeproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	final static String SHARED_NAME_STRING="sharedp"; 
	final static String USER_NAME_STRING="user";
	Button btn;
	EditText edt;
	SharedPreferences sharedPreferences;
	String userNameString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		btn = (Button) findViewById(R.id.button1);
		edt = (EditText) findViewById(R.id.editText1);
		
		Log.d("DICTIONARY", "MainActivity Started");
		sharedPreferences = getSharedPreferences(SHARED_NAME_STRING, MODE_PRIVATE);
		userNameString=sharedPreferences.getString(USER_NAME_STRING, "");
		edt.setText(userNameString);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				String string = edt.getText().toString();
				Intent in = new Intent(MainActivity.this,DictionaryListActivity.class);
				in.putExtra("user",string);
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString(userNameString, string);
				editor.commit();
				startActivity(in);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
