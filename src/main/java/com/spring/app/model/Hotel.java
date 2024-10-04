package com.spring.app.model;

import java.io.Serializable;

/**
 *
 * @author RP
 */
/**
 * This is a model of the hotel object with its attributes.
 */
public class Hotel implements Serializable {

    // Create private fields for hotel class

    // Create an empty constructor for hotel class

    // Create a constructor for hotel class

    // Create accessor methods (i.e., getter and setter methods) for private field
    private int threshold;
    public Hotel() {}
    public Hotel(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }
}
