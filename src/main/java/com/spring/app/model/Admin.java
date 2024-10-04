package com.spring.app.model;

import java.io.Serializable;

/**
 *
 * @author RP
 */
/**
 * This is a model of the admin object with its attributes.
 */


public class Admin implements Serializable {

// Create private fields for admin class

// Create an empty constructor for admin class

// Create a constructor for admin class

// Create accessor methods (i.e., getter and setter methods) for private field
    private String adminEmail;
    private String adminPassword;
    
    public Admin(){}
    
    public Admin(String adminEmail, String adminPassword){
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }
    
    public String getAdminEmail(){
        return adminEmail;
    }
    
    public void setAdminEmail(String adminEmail){
        this.adminEmail = adminEmail;
    }
    
    public String getAdminPassword(){
        return adminPassword;
    }
    
    public void setAdminPassword(String adminPassword){
        this.adminPassword = adminPassword;
    }

    
}

