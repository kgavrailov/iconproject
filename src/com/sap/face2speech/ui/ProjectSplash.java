package com.sap.face2speech.ui;


import com.sap.face2speech.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ProjectSplash extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
		ImageView logo1 = (ImageView) findViewById(R.id.ImageView01);
		Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		logo1.startAnimation(fade1);
		
		fade1.setAnimationListener(new AnimationListener() {
			
			public void onAnimationEnd(Animation arg0) {
				startActivity(new Intent(ProjectSplash.this, ApplicationHome.class));
				ProjectSplash.this.finish();
			}
			
			public void onAnimationStart(Animation arg0) {
				
			}
			
			public void onAnimationRepeat(Animation arg0) {
			}
		});
    }
}