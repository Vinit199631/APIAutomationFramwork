package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.response.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {


    @Test(groups = "reg",priority = 1)
    @Owner("Vinit")
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingPOST_Positive(){

        // Setup- MAking a req part
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification ).when().body(payloadManager.createPayloadBookingAsString()).log().all().post();
        System.out.println(response.asString());
        // Extraction
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //Verification
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Pramod");


    }

    @Test(groups = "reg",priority = 1)
    @Owner("Vinit")
    @Description("TC#1 - Verify that the Booking can't be Created(When Payload is Null)")
    public void testCreateBookingPOST_Negative(){

        // Setup- Making a req part
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification ).when().body("{}").log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);


    }

    @Test(groups = "reg",priority = 1)
    @Owner("Vinit")
    @Description("TC#1 - Verify that the Booking can't be Created with special Characters")
    public void testCreateBookingPOST_Positive_specialChar(){

        // Setup- Making a req part
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification ).when().body(payloadManager.createPayloadBookingAsStringWrongBody()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }

    @Test(groups = "reg",priority = 1)
    @Owner("Vinit")
    @Description("TC#1 - Verify that the Booking can't be Created with Random Payload")
    public void testCreateBookingPOST_Positive_RANDOM_DATA(){

        // Setup- Making a req part
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification ).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }






}
