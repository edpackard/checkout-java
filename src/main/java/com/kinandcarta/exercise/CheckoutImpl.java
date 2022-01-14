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
    private int tenPercentOfferMinimum;
    private int discountedWaterBottlePrice;

    public CheckoutImpl(){
        items = new HashMap<String, Item>();
        basket = new ArrayList<String>();
        tenPercentOfferMinimum = 7500;
        discountedWaterBottlePrice = 2299;
        generateItems();
    }

    private void generateItems() {
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

        int subtotal = basket.stream()
                .map(itemId -> items.get(itemId))
                .map(item -> item.getItemPrice())
                .reduce(0, Integer::sum);

        int total = applyDiscount(subtotal);

        return total;
    }

    private int applyDiscount(int subtotal) {

        long count = basket.stream()
                .filter(item -> "0001".equals(item)).count();
        if (count > 1) {
            subtotal -= (items.get("0001").getItemPrice() - discountedWaterBottlePrice) * count;
        }

        if (subtotal > tenPercentOfferMinimum) {
            subtotal -= Math.round(subtotal / 10.00);
        }

        return subtotal;
    }
}
