package com.example.dictinarycollegeproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class WordDefinitionDetailActivity extends Activity {
TextView tv1,tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_definition_detail);
		tv1 = (TextView) findViewById(R.id.textView2);
		tv2 = (TextView) findViewById(R.id.textView4);
		
		tv1.setText(getIntent().getStringExtra("word"));
		//tv2.setText(getIntent().getStringExtra("definition"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_word_definition_detail, menu);
		return true;
	}

}
