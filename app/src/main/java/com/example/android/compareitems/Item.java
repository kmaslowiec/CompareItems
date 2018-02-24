package com.example.android.compareitems;

/**
 * Created by Kondzik on 2018-02-23.
 * Inlcudes the Item name, price and description of the item
 *
 */

public class Item extends MainActivity {

    int itemName;
    int picId;
    int itemPrice;
    int itemDesImportant;
    int itemDesOther;

    Item(int itemName, int picId, int itemPrice, int itemDesImportant, int itemDesOther){
        this.itemName = itemName;
        this.picId = picId;
        this.itemPrice = itemPrice;
        this.itemDesImportant = itemDesImportant;
        this.itemDesOther = itemDesOther;


    }


}
