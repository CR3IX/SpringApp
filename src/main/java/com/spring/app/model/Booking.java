package com.spring.app.model;

/**
 *
 * @author RP
 */
/**
 * This is a model of the booking object with its attributes.
 */
public class Booking {

// Create private fields for booking class

// Create an empty constructor for booking class

// Create a constructor for booking class

// Create accessor methods (i.e., getter and setter methods) for private field

    private int customerId;
    private String customerName;
    private String customerEmail;
    private String dateAndTime;
    private String customerPhone;
    private int persons;
    public Booking() {
    }

    public Booking(int customerId, String customerName, String customerEmail, int tableNumber, String dateAndTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.dateAndTime = dateAndTime;
        this.customerPhone = customerPhone;
        this.persons = persons;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }
    
    public int getPersons() {
        return persons;
    }
}
