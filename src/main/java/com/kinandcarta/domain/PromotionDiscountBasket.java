package com.kinandcarta.domain;

import java.util.List;

public class PromotionDiscountBasket implements Promotion {

    double percentageDiscount;
    int qualifyingSpend;

    public PromotionDiscountBasket(double percentage, int minSpend) {
        qualifyingSpend = minSpend;
        percentageDiscount = percentage;
    }

    @Override
    public int applyPromotion(int subtotal, List basket) {
        if (subtotal > qualifyingSpend) {
            subtotal -= Math.round(subtotal / percentageDiscount);
        }
        return subtotal;
    }
}
