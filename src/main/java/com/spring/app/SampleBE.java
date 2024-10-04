/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.app;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.spring.app.model.Admin;
import com.spring.app.model.Booking;
import com.spring.app.model.Customer;
import com.spring.app.model.Hotel;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author RP
 */
@Service
public class SampleBE {

    private static SampleBE SampleBE = null;
    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;
    @Autowired
    JdbcTemplate jdbc;

    private SampleBE() {
        SampleBE = this;
    }

    public static SampleBE getInstance() {
        if (SampleBE == null) {
            SampleBE = new SampleBE();
        }
        return SampleBE;
    }

    public int adminLogin(Admin admin) {

        /**
         * This method is used to login as admin.
         *
         * @param admin This is the parameter to adminLogin method.
         * @return int This returns count of adminLogin SUCCESS or FAILURE.
         */
        // Write the adminLogin() code below
        String s = "select count(*) from admin where admusername=? AND admpassword=?";
        int count = 0;
        try {
            count = jdbc.queryForObject(s, new Object[] { admin.getAdminEmail(),
                    admin.getAdminPassword() }, Integer.class);
        } catch (Exception e) {
            System.out.println("Exception" + e);
            count = 0;
        }
        if (count == 1) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    public List<Booking> viewBooking() {

        /**
         * This method is used to view bookings.
         *
         * @param args Unused.
         * @return list This returns list of bookings.
         */
        // Write the viewBooking() code below
        String s = "select bkgid AS id, bkgname AS name, bkgemail AS email, bkgphone AS phone, bkgfromdatetime AS datetime, bkgnoofperson AS person from booking";
        List bklist;
        try {
            bklist = jdbc.queryForList(s);
        } catch (Exception e) {
            System.out.println("Exception" + e);
            bklist = null;
        }
        return bklist;
    }

    public int clearBookings() {

        /**
         * This method is used to clear bookings.
         *
         * @param args Unused.
         * @return int This returns status of clearBookings SUCCESS or FAILURE.
         */
        // Write the clearBookings() code below
        String s = "delete from booking";
        int resultRec = 0;
        try {
            resultRec = jdbc.update(s);
        } catch (Exception e) {
            System.out.println("Exception" + e);
            resultRec = 0;
        }
        return resultRec ==1 ? resultRec :1;
    }

    public JSONObject customerLogin(Customer customer) {

        /**
         * This method is used to login as customer.
         *
         * @param customer This is the parameter to customerLogin method.
         * @return Long This returns customerID as Long or null if customer not found.
         */
        // Write the customerLogin() code below
        String s = "select cstid as Id from customer where cstemail='" + customer.getEmail() + "' AND cstpassword='" + customer.getPassword() + "'";
        List customerlist;
        try {
            customerlist = jdbc.queryForList(s);
            JSONObject json = new JSONObject();
            if (!customerlist.isEmpty()) {
                json.put("status",1);
                json.put("CustomerID", customerlist);
                System.out.println("json = " + json);
                return json;
            }
            else{
                json.put("status", 0);
                return json;
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
            customerlist = null;
        }
        
        
        return null;
    }

    public int customerRegister(Customer customer) {

        /**
         * This method is used to register as customer.
         *
         * @param customer This is the parameter to customerRegister method.
         * @return int This returns status of customerRegister SUCCESS or
         *         FAILURE.
         */
        // Write the customerRegister() code below
        String s = "insert into customer(cstname,cstemail,cstphone,cstpassword)values(?,?,?,?)";
        int insert = 0;
        try {
            insert = jdbc.update(s, customer.getName(), customer.getEmail(),
                    customer.getPhone(), customer.getPassword());
        } catch (Exception e) {
            System.out.println("Exception" + e);
            insert = 0;
        }
        if (insert == 1) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    public int createBooking(Booking booking) {

        /**
         * This method is used to create booking.
         *
         * @param booking This is the parameter to createBooking method.
         * @return int This returns status of createBooking SUCCESS or FAILURE.
         */
        // Write the following code below
        String sql = "insert into booking(bkgname,bkgemail,bkgphone,bkgnoofperson,bkgfromdatetime,bkgcstid)values(?,?,?,?,?,?)";
        int insert = 0;
        try {
            int rowsAffected = jdbc.update(sql, booking.getCustomerName(), booking.getCustomerEmail(),
                    booking.getCustomerPhone(), booking.getPersons(), booking.getDateAndTime(),
                    booking.getCustomerId());
            insert = (rowsAffected > 0) ? SUCCESS : FAILURE;
        } catch (Exception e) {
            System.out.println("Exception" + e);
            insert = FAILURE;
        }
        return insert;
    }

    public int checkAvailability(int threshold) {

        /**
         * This method is used to check booking availability.
         *
         * @param threshold This is the parameter to checkAvailability method.
         * @return int This returns status of checkAvailability SUCCESS or
         *         FAILURE.
         */
        // Write the checkAvailability() code below
        String s = "select htlthreshold AS threshold from hotel";
        List<Hotel> thresholdlist = jdbc.query(s, new BeanPropertyRowMapper(Hotel.class));
        int availability = thresholdlist.get(0).getThreshold();
        System.out.println("availability = " + availability);
        String t = "select sum(bkgnoofperson) AS person from booking";
        long thresholddblist = 0;
        if (jdbc.queryForObject(t, Long.class) != null) {
            thresholddblist = jdbc.queryForObject(t, Long.class);
        }
        int reserved = 0;
        if (thresholddblist > 0) {
            reserved = Integer.parseInt(thresholddblist + "");
            System.out.println("reserved = " + reserved);
        }
        int totalperson = reserved + threshold;
        System.out.println("totalperson = " + totalperson);
        if (availability >= totalperson) {
            return FAILURE;
        } else {
            return SUCCESS;
        }
    }

    public int checkUser(String email) {

        /**
         * This method is used to check whether customer already exists or not.
         * If exists, returns the id of the customer.
         *
         * @param email This is the parameter to checkUser method.
         * @return int This returns id of the customer or -1 if not found.
         */
        // Write the checkUser() code below
        String s = "select cstid from customer WHERE cstemail=?";
        Integer id = 0;
        try {
            id = jdbc.queryForObject(s, new Object[] { email }, Integer.class);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return id;
    }

}
