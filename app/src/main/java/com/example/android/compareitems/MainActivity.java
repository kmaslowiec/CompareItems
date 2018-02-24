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
    CheckBox leftBox;
    CheckBox rightBox;
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
        leftBox = findViewById(R.id.checkbox_left);
        rightBox = findViewById(R.id.checkbox_right);
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
    }

    /**
     * Increase numRight
     * @param v
     */

    public void incRight(View v){
        if(numRight<2)
        numRight++;

        setItemRight(arrayItem[numRight]);
    }

    /**
     * Decrease numLeft
     * @param v
     */

    public void decLeft(View v){
        if(numLeft>0)
        numLeft--;

        setItemLeft(arrayItem[numLeft]);
    }

    /**
     * Decrease numRight
     * @param v
     */

    public void decRight(View v){
        if(numRight>0)
        numRight--;
        setItemRight(arrayItem[numRight]);
    }

    // END OF INCREASING AND DECREASING NUM RIGHT AND LEFT METHODS

    /**
     * sets the details: name, picture, price and description for item in the left layout
     * @param i = Item Class
     */
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

    /**
     * sets the details: name, picture, price and description for item in the right layout
     * @param i = Item Class
     */
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

    /**
     * resets all function to the starting point
     * @param v
     */
    public void reset(View v){
        numLeft=0;
        setItemLeft(arrayItem[numLeft]);
        numRight=0;
        setItemRight(arrayItem[numRight]);
        leftBox.setChecked(false);
        rightBox.setChecked(false);


    }

    /**
     * reacts on the CheckBoxes and sends the info to the e-mail intent
     * @param v
     */
    public void submit(View v){


        int x = 0;

        if(leftBox.isChecked()){
            x = numLeft;
        }
        else if(rightBox.isChecked()){
            x = numRight;
        }

        if(leftBox.isChecked() && rightBox.isChecked()){
            Toast.makeText(this , "Please choose only one item", Toast.LENGTH_SHORT).show();
        }
        else if(!leftBox.isChecked() && !rightBox.isChecked()){
            Toast.makeText(this , "Please choose at least one item", Toast.LENGTH_SHORT).show();
        }
        else{
            Item i = arrayItem[x];
            sendEmail(i);
        }
    }

    /**
     * Sends the e-mail with the items details
     * @param i = Item class
     */
    public void sendEmail(Item i){
        String orderInfo = String.format(Locale.GERMANY,"Price:%d \n %s", i.itemPrice, getResources().getString(i.itemDesImportant));

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:info@urbanform.eu"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for " + getResources().getString(i.itemName));
        intent.putExtra(Intent.EXTRA_TEXT, orderInfo);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
