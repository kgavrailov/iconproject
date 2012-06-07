package com.sap.face2speech.ui;

import com.sap.face2speech.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApplicationHome extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.applicationhome);
	}

	public void clickKircho(View view) {		
		startActivity(new Intent(ApplicationHome.this, ResultScreen.class));
	}
}
