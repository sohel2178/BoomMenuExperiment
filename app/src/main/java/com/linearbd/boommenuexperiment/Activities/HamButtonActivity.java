package com.linearbd.boommenuexperiment.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linearbd.boommenuexperiment.R;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;

public class HamButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ham_button);

        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);


        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(R.drawable.butterfly)
                    .normalText("Butter Doesn't fly!")
                    .subNormalText("Little butter Doesn't fly, either!");
            bmb.addBuilder(builder);
        }
    }
}
