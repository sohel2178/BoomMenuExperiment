package com.linearbd.boommenuexperiment.Activities;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.linearbd.boommenuexperiment.R;
import com.linearbd.boommenuexperiment.Utility.RevealAnimation;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Util;

public class CustomButtonActivity extends AppCompatActivity {
    private FloatingActionButton fabRevealTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_button);

        final BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        fabRevealTest = findViewById(R.id.fab_reveal_test);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fabRevealTest.setTransitionName("reveal");
        }
        fabRevealTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calculates the center of the View v you are passing
                int revealX = (int) (view.getX() + view.getWidth() / 2);
                int revealY = (int) (view.getY() + view.getHeight() / 2);

                //create an intent, that launches the second activity and pass the x and y coordinates
                Intent intent = new Intent(getApplicationContext(), CircularRevealActivity.class);
                intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
                intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);

                //just start the activity as an shared transition, but set the options bundle to null
                ActivityCompat.startActivity(getApplicationContext(), intent, null);

                //to prevent strange behaviours override the pending transitions
                overridePendingTransition(0, 0);

            }
        });

        /*bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+6), Util.dp2px(-6)));
        bmb.getCustomPiecePlacePositions().add(new PointF(0, 0));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-6), Util.dp2px(+6)));

        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-80), Util.dp2px(-80)));
        bmb.getCustomButtonPlacePositions().add(new PointF(0, 0));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+80), Util.dp2px(+80)));*/

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.butterfly)
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            //calculates the center of the View v you are passing
                            int revealX = (int) (bmb.getBoomButton(index).getX() + bmb.getBoomButton(index).getWidth() / 2);
                            int revealY = (int) (bmb.getBoomButton(index).getY() + bmb.getBoomButton(index).getHeight() / 2);

                            //create an intent, that launches the second activity and pass the x and y coordinates
                            Intent intent = new Intent(getApplicationContext(), CircularRevealActivity.class);
                            intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
                            intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);

                            //just start the activity as an shared transition, but set the options bundle to null
                            ActivityCompat.startActivity(getApplicationContext(), intent, null);

                            //to prevent strange behaviours override the pending transitions
                            overridePendingTransition(0, 0);
                        }
                    })
                    .normalText("Butter Doesn't fly!");
            bmb.addBuilder(builder);
        }
    }
}
