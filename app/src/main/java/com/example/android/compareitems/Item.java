package com.example.android.compareitems;

/**
 * Created by Kondzik on 2018-02-23.
 * Inlcudes the Item name, price and description of the item
 *
 */

public class Item extends MainActivity {

    String itemName;
    int itemPrice;
    String itemDes;

    Item(String itemName, int itemPrice, String itemDes){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDes = itemDes;


    }


}
