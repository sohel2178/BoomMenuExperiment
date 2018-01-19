package com.linearbd.boommenuexperiment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.linearbd.boommenuexperiment.R;
import com.linearbd.boommenuexperiment.Utility.RevealAnimation;

public class CircularRevealActivity extends AppCompatActivity {
    RevealAnimation mRevealAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        Intent intent = this.getIntent();   //get the intent to recieve the x and y coords, that you passed before

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout); //there you have to get the root layout of your second activity
        mRevealAnimation = new RevealAnimation(rootLayout, intent, this);

    }

    @Override
    public void onBackPressed() {
        mRevealAnimation.unRevealActivity();
        super.onBackPressed();
    }
}
