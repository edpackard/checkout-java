package com.kinandcarta.exercise;

import com.kinandcarta.domain.Item;
import com.kinandcarta.domain.ItemImpl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CheckoutImpl implements Checkout {

    private Map<String, Item> items;
    private List<String> basket;

    public CheckoutImpl(){
       items = new HashMap<String, Item>();
       basket = new ArrayList<String>();
       items.put("0001", new ItemImpl ("Water Bottle", 2495));
       items.put("0002", new ItemImpl ("Hoodie", 6500));
       items.put("0003", new ItemImpl ("Sticker Set", 399));
    }

    @Override
    public void scan(List<String> itemIds) {
        for (String itemId : itemIds) {
            if (items.containsKey(itemId)) {
                basket.add(itemId);
            } else {
                throw new RuntimeException("Invalid itemId");
            }
        }
    }

    @Override
    public int getTotal() {
        int total = 0;
        for (String itemId : basket) {
            Item item = items.get(itemId);
            total += item.getItemPrice();
        }

        // At a later point we'll want to apply the discounts at this point, but you can skip this for now.

        return total;
    }
}
