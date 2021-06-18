package com.example.dictinarycollegeproject;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;

public class SplashActivity extends Activity implements TextToSpeech.OnInitListener{
TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		tts = new TextToSpeech(this,this);
		
TimerTask tt=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),ChooserActivity.class);
				startActivity(i);
				finish();
			}
		};
		Timer t1=new Timer();
		t1.schedule(tt, 4000);


		
		
	}
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
		tts.setLanguage(Locale.US);
		tts.setPitch(5);
		abc();
		
	}

void abc()
{
	tts.speak(" the dictionary App",TextToSpeech.QUEUE_FLUSH, null);
}

}
