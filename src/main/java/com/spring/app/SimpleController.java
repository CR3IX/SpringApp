/**
* <h1>Restaurant Table Reservation Application</h1>
* This program implements an application that
* allows customer to register and login, book a slot, check booking availability and also the admin can login to view bookings and clear bookings.
* 
* @author  RP
* @version 1.0
* @since   2022-11-04
*/

package com.spring.app;

import com.spring.app.model.Booking;
import com.spring.app.model.Admin;
import com.spring.app.model.Customer;
import com.spring.app.model.Hotel;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class SimpleController {

    @Autowired
    JdbcTemplate jdbc;

    SampleBE BEObj = SampleBE.getInstance();

    // Write a controller to handle admin login code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int adminLogin(@RequestBody Admin admin) {
        int result = BEObj.adminLogin(admin);
        return result;
    }

    // Write a controller to list bookings code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/viewbooking", method = RequestMethod.GET)
    public List<Booking> viewBooking() {
        List<Booking> result = BEObj.viewBooking();
        return result;
    }

    // Write a controller to clear bookings code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/clearbookings", method = RequestMethod.POST)
    public int clearBookings() {
        int result = BEObj.clearBookings();
        return result;
    }

    // Write a controller to handle customer login code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/customerlogin", method = RequestMethod.POST)
    public JSONObject customerLogin(@RequestBody Customer customer) {
        JSONObject result = BEObj.customerLogin(customer);
        return result;
    }

    // Write a controller to handle customer register code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/customerregister", method = RequestMethod.POST)
    public int customerRegister(@RequestBody Customer customer) {
        int result = BEObj.customerRegister(customer);
        return result;
    }

    // Write a controller to create booking code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/createbooking", method = RequestMethod.POST)
    public int createBooking(@RequestBody Booking booking) {
        int result = BEObj.createBooking(booking);
        return result;
    }

    // Write a controller to check booking availability code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/checkavailability", method = RequestMethod.POST)
    public int checkAvailability(@RequestBody Hotel hotel) {
        int result = BEObj.checkAvailability(hotel.getThreshold());
        return result;
    }

    // Write a controller to check user already exists code below
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    public int checkUser(@RequestBody Customer customer) {
        int result = BEObj.checkUser(customer.getEmail());
        return result;

    }

}
