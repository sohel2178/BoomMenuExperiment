package com.linearbd.boommenuexperiment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.linearbd.boommenuexperiment.R;
import com.linearbd.boommenuexperiment.SimpleCircleButtonActivity;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listenClickEventOf(R.id.simple_circle_button_example);
        listenClickEventOf(R.id.text_inside_circle_button_example);
        listenClickEventOf(R.id.text_outside_circle_button_example);
        listenClickEventOf(R.id.ham_button_example);
        listenClickEventOf(R.id.square_and_piece_corner_radius_example);
        listenClickEventOf(R.id.boom_example);
        listenClickEventOf(R.id.button_place_alignment_example);
        listenClickEventOf(R.id.order_example);
        listenClickEventOf(R.id.actionbar_example);
        listenClickEventOf(R.id.tool_bar_example);
        listenClickEventOf(R.id.draggable_example);
        listenClickEventOf(R.id.ease_example);
        listenClickEventOf(R.id.listener_example);
        listenClickEventOf(R.id.control_example);
        listenClickEventOf(R.id.share_example);
        listenClickEventOf(R.id.list_example);
        listenClickEventOf(R.id.recycler_view_example);
        listenClickEventOf(R.id.fragment_example);
        listenClickEventOf(R.id.change_boom_button_example);
        listenClickEventOf(R.id.three_d_animation_example);
        listenClickEventOf(R.id.custom_position_example);
        listenClickEventOf(R.id.fade_views_example);
        listenClickEventOf(R.id.orientation_example);


    }

    private void listenClickEventOf(int id) {
        findViewById(id).setOnClickListener(this);
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simple_circle_button_example:
                startActivity(SimpleCircleButtonActivity.class);
                break;
        }
    }
}
