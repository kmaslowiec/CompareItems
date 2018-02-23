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
import android.widget.TextView;

import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private int numLeft = 0;
    private int numRight = 0;
    private Item[] arrayItem = new Item[3];
   //Item[] arrayItem = {new Item(getResources().getString(R.string.item1_name), 15, getResources().getString(R.string.item1_des))};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        arrayItem[0] = new Item(getResources().getString(R.string.item1_name), R.drawable.flower_pot_small , 15, getResources().getString(R.string.item1_des));
        arrayItem[1] = new Item(getResources().getString(R.string.item2_name), R.drawable.flower_pot_medium, 25, getResources().getString(R.string.item2_des));
        arrayItem[2] = new Item(getResources().getString(R.string.item3_name), R.drawable.flower_pot_big, 35, getResources().getString(R.string.item3_des));
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

    public void clicktest(View v){

        setItemLeft(arrayItem[numLeft]);


    }

    public void setItemLeft(Item i) {
        TextView name = findViewById(R.id.item_name_left);
        name.setText(i.itemName);

        ImageView pic = findViewById(R.id.image_left);
        pic.setImageResource(i.picId);

        TextView price = findViewById(R.id.price_left);
        price.setText(NumberFormat.getCurrencyInstance().format(i.itemPrice));

        TextView des = findViewById(R.id.description_left);
        des.setText(i.itemDes);


    }

    /*public void printItem(View v){
        Log.i("Item", item.hello);
    }*/
}
