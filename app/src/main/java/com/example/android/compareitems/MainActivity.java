package com.example.android.compareitems;

import android.app.Activity;
import android.media.Image;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private int numLeft = 0;
    private int numRight = 0;
    Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        item = new Item();


    }

    // INCREASING AND DECREASING NUM RIGHT AND LEFT METHODS

    /**
     * Increase numLeft
     * @param v
     */

    public void incLeft(View v){

        if(numLeft<2)
        numLeft++;
        Log.i("info1", "inc left " + numLeft);

    }

    /**
     * Increase numRight
     * @param v
     */

    public void incRight(View v){
        if(numRight<2)
        numRight++;
        Log.i("info2", "inc Right " + numRight);
    }

    /**
     * Decrease numLeft
     * @param v
     */

    public void decLeft(View v){
        if(numLeft>0)
        numLeft--;
        Log.i("info3", "dec Left " + numLeft);
    }

    /**
     * Decrease numRight
     * @param v
     */

    public void decRight(View v){
        if(numRight>0)
        numRight--;
        Log.i("info4", "dec Right " + numRight);
    }

    // END OF INCREASING AND DECREASING NUM RIGHT AND LEFT METHODS

    public void biggerPic(View v){

        ImageView pic = (ImageView) findViewById(R.id.image_left);
        pic.setImageResource(R.drawable.flower_pot_medium);


    }

    /*public void printItem(View v){
        Log.i("Item", item.hello);
    }*/
}
