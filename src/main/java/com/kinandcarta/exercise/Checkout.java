package com.kinandcarta.exercise;

/**
 * The interface that defines a Checkout.  This means that all classes which say 'implements Checkout'
 * as part of their definition MUST define these methods.
 */
public interface Checkout {

    /**
     * Adds the given item to the basket.
     *
     * @param itemId the item id to add to the basket
     */
    void addItem(String itemId);

    /**
     * Gets the total for the basket.
     *
     * @return the total price for the basket, in pence
     */
    int getTotal();
}
