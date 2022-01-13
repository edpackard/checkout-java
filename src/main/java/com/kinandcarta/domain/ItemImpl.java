package com.kinandcarta.domain;

public class ItemImpl implements Item {

    private String itemDesc;

    private int itemPrice;

    public ItemImpl(String desc, int price) {
        itemDesc = desc;
        itemPrice = price;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public int getItemPrice() {
        return itemPrice;
    }

}
