package com.thetestingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.pojos.request.Auth;
import com.thetestingacademy.pojos.request.Booking;
import com.thetestingacademy.pojos.request.BookingDates;
import com.thetestingacademy.pojos.response.BookingResponse;
import com.thetestingacademy.pojos.response.TokenResponse;

public class PayloadManager {


    Gson gson;
    Faker faker;
    public String createPayloadBookingAsString(){

        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Serialization - Java Object to JSON
         gson = new Gson();
        String jsdonStringBooking = gson.toJson(booking);
        return jsdonStringBooking;
    }

    public String createPayloadBookingAsStringWrongBody(){

        Booking booking = new Booking();
        booking.setFirstname("*&8^$##$");
        booking.setLastname("*&8^$##$");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("5025-02-01");
        bookingDates.setCheckout("5025-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Serialization - Java Object to JSON
        gson = new Gson();
        String jsdonStringBooking = gson.toJson(booking);
        return jsdonStringBooking;
    }


    // De-Serialization - JSON to Java Object to verify the response
    public BookingResponse bookingResponseJava(String responseString){
         gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;

    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }

    // DeSer ( JSON String -> Java Object
    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return  tokenResponse1.getToken();
    }

    public String createPayloadBookingFakerJS(){

        Faker faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1,1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Serialization - Java Object to JSON
        gson = new Gson();
        String jsdonStringBooking = gson.toJson(booking);
        return jsdonStringBooking;
    }

    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

}






