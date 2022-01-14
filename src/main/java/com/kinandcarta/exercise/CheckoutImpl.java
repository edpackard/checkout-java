package com.kinandcarta.exercise;

import com.kinandcarta.domain.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CheckoutImpl implements Checkout {

    private Map<String, Item> items;
    private List<String> basket;
    private Promotion discount;
    private Promotion reduction;

    public CheckoutImpl(){
        items = new HashMap<String, Item>();
        basket = new ArrayList<String>();
        generateItems();
        generatePromotions();
    }

    private void generateItems() {
        items.put("0001", new ItemImpl ("Water Bottle", 2495));
        items.put("0002", new ItemImpl ("Hoodie", 6500));
        items.put("0003", new ItemImpl ("Sticker Set", 399));
    }

    private void generatePromotions() {
        discount = new PromotionDiscountBasket(10.00, 7500);
        reduction = new PromotionMultibuySaving("0001", items.get("0001").getItemPrice(), 2299, 2);
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
        int total = applyPromotions(subtotal);
        return total;
    }

    private int applyPromotions(int subtotal) {
        subtotal = reduction.applyPromotion(subtotal, basket);
        subtotal = discount.applyPromotion(subtotal, basket);
        return subtotal;
    }
}
