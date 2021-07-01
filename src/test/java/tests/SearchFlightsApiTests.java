package tests;

import TestEnums.FlightClass;
import TestEnums.PassengerType;
import helpers.DateHelper;
import helpers.SearchFlightsApiHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class SearchFlightsApiTests {

    @Test
    public void verifySearchFlightsAPIIsUpTest() throws ParseException {

        Response response = SearchFlightsApiHelper.searchFlights("SHJ","CAI", DateHelper.getDateAfter(1),
                        FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.getBody().asString().contains("originId\":\"SHJ"));
        Assert.assertTrue(response.getBody().asString().contains("destinationId\":\"CAI"));
        Assert.assertTrue(response.getBody().asString().contains("cabin\":\"Economy"));
    }

    @Test
    public void verifySearchFlightsWithInvalidOrigin() throws ParseException {

        Response response = SearchFlightsApiHelper.searchFlights("111","CAI", DateHelper.getDateAfter(1),
                FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    public void verifySearchFlightsWithInvalidDestination() throws ParseException {

        Response response = SearchFlightsApiHelper.searchFlights("SHJ","111", DateHelper.getDateAfter(1),
                FlightClass.ECONOMY.getValue(), "1"+ PassengerType.ADULT.getValue());

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    public void verifySearchFlightsWithPastDate() throws ParseException {

        Response response = SearchFlightsApiHelper.searchFlights("SHJ","CAI", DateHelper.getDateAfter(-2),
                FlightClass.FIRST.getValue(), "1"+ PassengerType.ADULT.getValue());

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    public void verifySearchFlightsWithIncorrectClassType() throws ParseException {

        Response response = SearchFlightsApiHelper.searchFlights("SHJ","CAI", DateHelper.getDateAfter(-2),
                "test", "1"+ PassengerType.ADULT.getValue());

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    public void verifySearchFlightsWithIncorrectPassengerType() throws ParseException {

        Response response = SearchFlightsApiHelper.searchFlights("SHJ","CAI", DateHelper.getDateAfter(-2),
                FlightClass.FIRST.getValue(), "test");

        Assert.assertEquals(400, response.getStatusCode());
    }
}
