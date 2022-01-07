package com.kinandcarta.exercise;

import java.util.List;

/**
 * The interface that defines a Checkout.  This means that all classes which say 'implements Checkout'
 * as part of their definition MUST define these methods.
 */
public interface Checkout {

    /**
     * Adds the given item to the basket.
     *
     * @param itemIds the item ids to add to the basket
     */
    void scan(List<String> itemIds);

    /**
     * Gets the total for the basket.
     *
     * @return the total price for the basket, in pence
     */
    int getTotal();
}
