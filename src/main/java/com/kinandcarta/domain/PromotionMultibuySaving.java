package com.kinandcarta.domain;

import java.util.List;

public class PromotionMultibuySaving implements Promotion {

    String itemId;
    int qualifyingPurchaseNo;
    int reduction;

    public PromotionMultibuySaving(String id, int originalPrice, int reducedPrice, int minPurchaseNo){
        itemId = id;
        reduction = originalPrice - reducedPrice;
        qualifyingPurchaseNo = minPurchaseNo;
    }

    @Override
    public int applyPromotion(int subtotal, List basket) {
        long count = basket.stream()
                .filter(item -> itemId.equals(item)).count();
        if (count >= qualifyingPurchaseNo) {
            subtotal -= reduction * count;
        }
        return subtotal;
    }
}
