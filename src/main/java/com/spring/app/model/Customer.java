package com.spring.app.model;

import java.io.Serializable;

/**
 *
 * @author RP
 */
/**
 * This is a model of the customer object with its attributes.
 */
public class Customer implements Serializable {

    // Create private fields for customer class

    // Create an empty constructor for customer class

    // Create a constructor for customer class

    // Create accessor methods (i.e., getter and setter methods) for private field
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Customer() {
    }

    public Customer(String name, String email, String phone, String password, int id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
