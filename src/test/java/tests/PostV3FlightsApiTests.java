package tests;

import TestEnums.FlightClass;
import TestEnums.PassengerType;
import helpers.DateHelper;
import helpers.PostV3FlightsApiHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class PostV3FlightsApiTests {

    private Response response;

    @Test
    public void verifyPostV3FlightsApiIsUpTest() throws ParseException {

        response = PostV3FlightsApiHelper.postV3Flights("SHJ","CAI", DateHelper.getDateAfter(4),
                FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());;
        Assert.assertEquals(200, response.getStatusCode());
        response.print();
        Assert.assertTrue(response.getBody().asString().contains("originId\":\"SHJ"));
        Assert.assertTrue(response.getBody().asString().contains("destinationId\":\"CAI"));
        Assert.assertTrue(response.getBody().asString().contains("cabin\":\"Economy"));
    }

    @Test
    public void verifyPostV3FlightsApiIWithInvalidOriginTest() throws ParseException {

        response = PostV3FlightsApiHelper.postV3Flights("","CAI", DateHelper.getDateAfter(10),
                FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());;
        Assert.assertEquals(200, response.getStatusCode());
        response.print();
        Assert.assertTrue(response.getBody().asString().contains("res\":[]"));
    }

    @Test
    public void verifyPostV3FlightsApiIWithInvalidDestinationTest() throws ParseException {

        response = PostV3FlightsApiHelper.postV3Flights("SHJ","", DateHelper.getDateAfter(10),
                FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());;
        Assert.assertEquals(200, response.getStatusCode());
        response.print();
        Assert.assertTrue(response.getBody().asString().contains("res\":[]"));
    }

    @Test
    public void verifyPostV3FlightsApiIWithInvalidDateTest() throws ParseException {

        response = PostV3FlightsApiHelper.postV3Flights("SHJ","CAI", DateHelper.getDateAfter(-2),
                FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());;
        Assert.assertEquals(200, response.getStatusCode());
        response.print();
        Assert.assertTrue(response.getBody().asString().contains("res\":[]"));
    }

    @Test
    public void verifyPostV3FlightsApiIWithInvalidClassTypeTest() throws ParseException {

        response = PostV3FlightsApiHelper.postV3Flights("SHJ","CAI", DateHelper.getDateAfter(10),
                "test", "1"+ PassengerType.ADULT.getValue());;
        Assert.assertEquals(200, response.getStatusCode());
        response.print();
        Assert.assertTrue(response.getBody().asString().contains("res\":[]"));
    }

    @Test
    public void verifyPostV3FlightsApiIWithInvalidPassengerTypeTest() throws ParseException {

        response = PostV3FlightsApiHelper.postV3Flights("SHJ","CAI", DateHelper.getDateAfter(10),
                FlightClass.ECONOMY.getValue(), "1"+ "test");;
        Assert.assertEquals(200, response.getStatusCode());
        response.print();
        Assert.assertTrue(response.getBody().asString().contains("res\":[]"));
    }
}
