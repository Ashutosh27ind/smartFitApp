package com.ascena.bestfitapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class NeedFitActivity extends AppCompatActivity {

    private SeekBar waistBar;
    private TextView waistTextView;

    private SeekBar hipBar;
    private TextView hipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_fit);

        Button btn = (Button)findViewById(R.id.find_result);
        btn.setTransformationMethod(null);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeedFitActivity.this, FitResultActivity.class));
            }
        });

        /*waistBar = (SeekBar) findViewById(R.id.waist_seekbar);
        waistTextView = (TextView) findViewById(R.id.waistM);
        waistTextView.setText(waistBar.getProgress() + "/" + waistBar.getMax());
        waistBar. setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                waistTextView.setText(pval + "/" + seekBar.getMax());
            }
        });

        hipBar = (SeekBar) findViewById(R.id.hip_seekbar);
        hipTextView = (TextView) findViewById(R.id.hipM);
        hipTextView.setText(hipBar.getProgress() + "/" + waistBar.getMax());
        hipBar. setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                hipTextView.setText(pval + "/" + seekBar.getMax());
            }
        });*/
    }
}
