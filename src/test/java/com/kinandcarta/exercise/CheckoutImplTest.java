package com.kinandcarta.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A simple unit test class to test {@link CheckoutImpl}.
 */
public class CheckoutImplTest {

    /**
     * Test that we can use the checkout class to compute a total.  No discounts are
     * applied in this first step.
     */
    @Test
    public void testWithoutDiscounts() {

        // Items 0001 and 0003 together should come to £28.94.  As this is returned as an int,
        // it will be 2894.  Notice that we are creating a new instance of the implementation
        // class (CheckoutImpl), but the variable's type is the interface that that class
        // implements (Checkout).
        Checkout checkout = new CheckoutImpl();
        checkout.addItem("0001");
        checkout.addItem("0003");
        // The last parameter is the string that will only be displayed when the first two parameters aren't equal.
        assertEquals(2894, checkout.getTotal(), "Total incorrect");
    }
}
