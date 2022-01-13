package com.kinandcarta.exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutImplTest {

    @Test
    public void testInvalidItem() {
        Checkout checkout = new CheckoutImpl();
        Exception exception = assertThrows(RuntimeException.class, () -> checkout.scan(Arrays.asList("0000")));
        assertEquals("Invalid itemId", exception.getMessage());
    }

    @Test
    public void testWithoutDiscounts() {
        Checkout checkout = new CheckoutImpl();
        checkout.scan(Arrays.asList("0001", "0003"));
        assertEquals(2894, checkout.getTotal(), "Total incorrect");
    }

//    /**
//     * Test the examples that are contained in the exercise description.
//     */
//    @Test
//    public void testExamplesFromExerciseDescription() {
//
//        Checkout checkout1 = new CheckoutImpl();
//        checkout1.scan(Arrays.asList("0001", "0001", "0002", "0003"));
//        assertEquals(10347, checkout1.getTotal(), "Total incorrect");
//
//        Checkout checkout2 = new CheckoutImpl();
//        checkout2.scan(Arrays.asList("0001", "0001", "0001"));
//        assertEquals(6897, checkout2.getTotal(), "Total incorrect");
//
//        Checkout checkout3 = new CheckoutImpl();
//        checkout3.scan(Arrays.asList("0001", "0001", "0002", "0003"));
//        assertEquals(10347, checkout3.getTotal(), "Total incorrect");
//    }
}
