package com.example.android.compareitems;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private int picNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }

    public void biggerPic(View v){

        ImageView pic = (ImageView) findViewById(R.id.image_left);
        pic.setImageResource(R.drawable.flower_pot_medium);


    }
}
