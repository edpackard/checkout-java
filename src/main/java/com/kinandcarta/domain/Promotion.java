package com.kinandcarta.domain;

import com.kinandcarta.exercise.Checkout;

import java.util.List;

public interface Promotion {

    int applyPromotion(int subtotal, List basket);

}

