package com.twigsoftwares.radar.radarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import radarComponent.Radar;
import radarComponent.RadarPoint;

public class MainActivity extends AppCompatActivity {

    Radar radar;
int k=0;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radar = (Radar) findViewById(R.id.radar);
        seekBar=(  SeekBar) findViewById(R.id.seekBar2);
        seekBar.setProgress(0);
        //And here set the reference Point (or for exemple your GPS location)
        radar.setReferencePoint(new RadarPoint("myLocation", 10.00000f,22.0000f));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int j, boolean b) {
                ArrayList<RadarPoint> points = new ArrayList<RadarPoint>();
                ArrayList<RadarPoint> newpoints = new ArrayList<RadarPoint>();
                points=    radar.getPoints();
                for (int i = 0; i <points.size() ; i++) {

                    float x= points.get(i).getX();
                    float y=points.get(i).getY();
                    RadarPoint radarPoint=new RadarPoint(points.get(i).getIdentifier(),x*seekBar.getProgress(),y*seekBar.getProgress());
                    newpoints.add(radarPoint);

                }
                radar.setPoints(newpoints);
                radar.refresh();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        // the other points in the Radar
        ArrayList<RadarPoint> points = new ArrayList<RadarPoint>();

        points.add(new RadarPoint("identifier1", 8.00200f,22.0000f));
        points.add(new RadarPoint("identifier4", 11.00200f,22.0000f));
        points.add(new RadarPoint("identifier5", 12.00220f,22.0000f));
        points.add(new RadarPoint("identifier6", 13.00420f,22.0010f));
        points.add(new RadarPoint("identifier7", 14.00200f,22.0000f));
        points.add(new RadarPoint("identifier8", 15.00220f,22.0000f));
        points.add(new RadarPoint("identifier9", 16.00420f,22.0010f));

        radar.setPoints(points);
        radar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String pinIdentifier = radar.getTouchedPin(event);
                if (pinIdentifier != null) {
                    Toast.makeText(MainActivity.this, pinIdentifier, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
