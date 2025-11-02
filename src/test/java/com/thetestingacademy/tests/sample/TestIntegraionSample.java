package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegraionSample {

    // Basically it is a template -> Reusable
    // Scenario
    // Create A Booking , Create a Token
    // Verify the get booking
    // Update the booking
    // Delete the booking

    @Test(groups = "qa",priority = 1)
    @Owner("Vinit")
    @Description("TC#INT1 - Step 1.Verify that the Booking can be Created")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 2)
    @Owner("Vinit")
    @Description("TC#INT1 - Step 2.Verify that the Booking By ID")
    public void testVerifyBookingID(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 3)
    @Owner("Vinit")
    @Description("TC#INT1 - Step 3.Verify Updated Booking By ID")
    public void testUpdateBookingID(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 4)
    @Owner("Vinit")
    @Description("TC#INT1 - Step 4.Delete the Booking By ID")
    public void testDeleteBookingID(){
        Assert.assertTrue(true);
    }
}
