package com.example.dictinarycollegeproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DictionaryListActivity extends Activity {

	EditText edt;
	Button btn;
	ListView listView;
	TextView tv;
	ArrayList<WordDefinition> allWordDefinitions = new ArrayList<WordDefinition>();
	DictionaryDatabaseHelper myDictionaryDatabaseHelper;
	SharedPreferences sharedPreferences;
	String logTagString = "DICTIONARY";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary_list);
		edt = (EditText) findViewById(R.id.searchEditText);
		btn = (Button) findViewById(R.id.searchButton);
		listView = (ListView) findViewById(R.id.dictionaryListView);
		tv = (TextView) findViewById(R.id.textView1);
		tv.setText(getIntent().getStringExtra(MainActivity.USER_NAME_STRING)+"'s Dictionary");
		
		
		myDictionaryDatabaseHelper = new DictionaryDatabaseHelper(this,"Dictionary", null, 1);
		sharedPreferences = getSharedPreferences(MainActivity.SHARED_NAME_STRING, MODE_PRIVATE);
		boolean initialized = sharedPreferences.getBoolean("initialized", false);
		
		if (initialized == false) {
			
			Log.d(logTagString, "initializing for the first time");
			initializeDatabase();
		} else {
            Log.d(logTagString,"db already initialized");
		}
		
		allWordDefinitions = myDictionaryDatabaseHelper.getAllwords();
		listView.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View view, ViewGroup arg2) {
				// TODO Auto-generated method stub
				if (view == null) {
					view = getLayoutInflater().inflate(R.layout.list_item, null);
				}
				TextView textView = (TextView) view.findViewById(R.id.showtext);
				textView.setText(allWordDefinitions.get(position).word);
				return view;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return allWordDefinitions.size();
			}
		});
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent in = new Intent(DictionaryListActivity.this,WordDefinitionDetailActivity.class);
				in.putExtra("word", allWordDefinitions.get(position).word);
				in.putExtra("definition", allWordDefinitions.get(position).definition);
				startActivity(in);
				
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String string = edt.getText().toString();
				WordDefinition wordDefinition = myDictionaryDatabaseHelper.getWordDefinition(string);
				if (wordDefinition == null) {
					Toast.makeText(DictionaryListActivity.this,"word not found", Toast.LENGTH_SHORT).show();
				} else {
					Intent in = new Intent(DictionaryListActivity.this,WordDefinitionDetailActivity.class);
					in.putExtra("word", wordDefinition.word);
					in.putExtra("definition", wordDefinition.definition);
					startActivity(in);
				}
			}
		});
		
	}
	private void initializeDatabase() {
		// TODO Auto-generated method stub
		InputStream inputStream = getResources().openRawResource(R.raw.dictionary);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		DictionaryLoader.loadData(bufferedReader, myDictionaryDatabaseHelper);
	}



}
