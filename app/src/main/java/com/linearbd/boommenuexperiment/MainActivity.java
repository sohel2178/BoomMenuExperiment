package com.linearbd.boommenuexperiment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.linearbd.boommenuexperiment.Activities.CustomButtonActivity;
import com.linearbd.boommenuexperiment.Activities.HamButtonActivity;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.nightonke.boommenu.Util;

import static com.nightonke.boommenu.ButtonEnum.SimpleCircle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int[] imageResources = new int[]{
            R.drawable.bat,
            R.drawable.bear,
            R.drawable.bee,
            R.drawable.butterfly,
            R.drawable.cat,
            R.drawable.deer,
            R.drawable.dolphin,
            R.drawable.eagle,
            R.drawable.horse,
            R.drawable.elephant,
            R.drawable.owl,
            R.drawable.peacock,
            R.drawable.pig,
            R.drawable.rat,
            R.drawable.snake,
            R.drawable.squirrel
    };

    private Button btnHam,btnCustomPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHam = findViewById(R.id.btn_ham);
        btnCustomPosition = findViewById(R.id.btn_custom_position);
        btnHam.setOnClickListener(this);
        btnCustomPosition.setOnClickListener(this);

        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_3_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_3_2);

        BoomMenuButton bmb2 = (BoomMenuButton) findViewById(R.id.bmb2);


        for (int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++) {
            bmb.addBuilder(new SimpleCircleButton.Builder()
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            Toast.makeText(MainActivity.this, "Click "+index, Toast.LENGTH_SHORT).show();
                        }
                    })
                    // Whether the boom-button should have a shadow effect.
                    .shadowEffect(true)
                    // Set the horizontal shadow-offset of the boom-button.
                    .shadowOffsetX(20)
                    // Set the vertical shadow-offset of the boom-button.
                    .shadowOffsetY(0)
                    // Set the radius of shadow of the boom-button.
                    .shadowRadius(Util.dp2px(20))

                    // Set the corner-radius of the shadow.
                    .shadowCornerRadius(Util.dp2px(20))
                    // Set the color of the shadow of boom-button.
                    .shadowColor(Color.parseColor("#ee000000"))
                    // Set the image resource when boom-button is at highlighted-state.
                    .highlightedImageRes(R.drawable.bat)
                    // Whether the button is a circle shape.
                    .isRound(true)
                    // The color of boom-button when it is at highlighted-state.
                    .highlightedColor(Color.BLUE)
                    .normalImageRes(R.drawable.bear));
        }


        for (int i = 0; i < bmb2.getPiecePlaceEnum().pieceNumber(); i++) {
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                    .normalImageRes(imageResources[i]);
            bmb2.addBuilder(builder);
        }


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ham:
                startActivity(new Intent(getApplicationContext(),HamButtonActivity.class));
                break;

            case R.id.btn_custom_position:
                startActivity(new Intent(getApplicationContext(),CustomButtonActivity.class));
                break;
        }

    }
}
