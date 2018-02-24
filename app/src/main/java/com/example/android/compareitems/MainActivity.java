package com.example.android.compareitems;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    private int numLeft = 0;
    private int numRight = 0;
    private Item[] arrayItem = new Item[3];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        arrayItem[0] = new Item(R.string.item1_name, R.drawable.flower_pot_small , 15, R.string.item1_des_important, R.string.item_des_other);
        arrayItem[1] = new Item(R.string.item2_name, R.drawable.flower_pot_medium, 25, R.string.item2_des_important, R.string.item_des_other);
        arrayItem[2] = new Item(R.string.item3_name, R.drawable.flower_pot_big, 35, R.string.item3_des_important, R.string.item_des_other);
        setItemLeft(arrayItem[0]);
        setItemRight(arrayItem[0]);

    }



    // INCREASING AND DECREASING NUM RIGHT AND LEFT METHODS

    /**
     * Increase numLeft
     * @param v
     */

    public void incLeft(View v){

        if(numLeft<2)
        numLeft++;

        setItemLeft(arrayItem[numLeft]);
        Log.i("info1", "inc left " + numLeft);

    }

    /**
     * Increase numRight
     * @param v
     */

    public void incRight(View v){
        if(numRight<2)
        numRight++;

        setItemRight(arrayItem[numRight]);
        Log.i("info2", "inc Right " + numRight);
    }

    /**
     * Decrease numLeft
     * @param v
     */

    public void decLeft(View v){
        if(numLeft>0)
        numLeft--;

        setItemLeft(arrayItem[numLeft]);
        Log.i("info3", "dec Left " + numLeft);
    }

    /**
     * Decrease numRight
     * @param v
     */

    public void decRight(View v){
        if(numRight>0)
        numRight--;
        setItemRight(arrayItem[numRight]);
        Log.i("info4", "dec Right " + numRight);
    }

    // END OF INCREASING AND DECREASING NUM RIGHT AND LEFT METHODS

    public void setItemLeft(Item i) {
        TextView name = findViewById(R.id.item_name_left);
        name.setText(getResources().getString(i.itemName));

        ImageView pic = findViewById(R.id.image_left);
        pic.setImageResource(i.picId);

        TextView price = findViewById(R.id.price_left);
        price.setText(NumberFormat.getCurrencyInstance().format(i.itemPrice));

        TextView des = findViewById(R.id.description_left);

        String description = String.format(Locale.CANADA, "%s \n %s",getResources().getString(i.itemDesImportant), getResources().getString(i.itemDesOther));
        des.setText(description);
    }

    public void setItemRight(Item i) {
        TextView name = findViewById(R.id.item_name_right);
        name.setText(getResources().getString(i.itemName));

        ImageView pic = findViewById(R.id.image_right);
        pic.setImageResource(i.picId);

        TextView price = findViewById(R.id.price_right);
        price.setText(NumberFormat.getCurrencyInstance().format(i.itemPrice));

        TextView des = findViewById(R.id.description_right);

        String description = String.format(Locale.CANADA, "%s \n %s",getResources().getString(i.itemDesImportant), getResources().getString(i.itemDesOther));
        des.setText(description);
    }

    public void reset(View v){
        numLeft=0;
        setItemLeft(arrayItem[numLeft]);
        numRight=0;
        setItemRight(arrayItem[numRight]);
    }

    public void submit(View v){
        CheckBox leftBox = findViewById(R.id.checkbox_left);
        CheckBox rightBox = findViewById(R.id.checkbox_right);

        int x = 0;

        Item i = arrayItem[x];
        String orderInfo = String.format(Locale.GERMANY,"Price:%d \n %s", i.itemPrice, getResources().getString(i.itemDesImportant));

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:info@urbanform.eu"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order of " + getResources().getString(i.itemName));
        intent.putExtra(Intent.EXTRA_TEXT, orderInfo);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }





        /*
        *//*if(leftBox.isChecked()){
            x = numLeft;
        }
        else if(rightBox.isChecked()){
            x = numRight;
        }*//*


        //if(leftBox.isChecked() || rightBox.isChecked()) {


            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:info@urbanform.eu"));
            intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.subject));
            intent.putExtra(Intent.EXTRA_TEXT, orderInfo);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        //}else{
            //Toast.makeText(this , "Please choose the item", Toast.LENGTH_SHORT).show();
        //}*/
    }


}
