package com.sap.face2speech.ui;

import java.util.Locale;

import com.sap.face2speech.R;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ResultScreen extends Activity implements
		TextToSpeech.OnInitListener {

	private static final String PERSON_DETAILS_DEFAULT = "The person in front of you is a male. He is approximately 25 years old. He is happy. He is smiling";
	private static final String LOCATION = ResultScreen.class.getName();
	private TextToSpeech mTextToSpeech;
	private Button mAgainButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_to_speech);
		mTextToSpeech = new TextToSpeech(this, this);
		mAgainButton = (Button) findViewById(R.id.again_button);

		mAgainButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				speakPersonDetails(PERSON_DETAILS_DEFAULT);
			}
		});
	}

	@Override
	public void onDestroy() {
		if (mTextToSpeech != null) {
			mTextToSpeech.stop();
			mTextToSpeech.shutdown();
		}
		super.onDestroy();
	}

	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			int result = mTextToSpeech.setLanguage(Locale.US);
			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e(LOCATION, "Language is not available.");
			} else {
				speakPersonDetails(PERSON_DETAILS_DEFAULT);
				mAgainButton.setEnabled(true);
			}
		} else {
			Log.e(LOCATION, "Could not initialize TextToSpeech.");
		}
	}

	private void speakPersonDetails(String personDetails) {
		mTextToSpeech.speak(personDetails, TextToSpeech.QUEUE_FLUSH, null);
	}

}
