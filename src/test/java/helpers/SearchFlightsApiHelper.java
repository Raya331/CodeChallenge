package helpers;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchFlightsApiHelper {

    static String TajwalURL = "https://www.tajawal.com";
    static String FlightsSearchService = "/api/v3/flights/flight/search?query=";

    public static Response searchFlights(String origin, String destination, String flightDate, String flightClass,
                                         String passengers){

        RestAssured.baseURI = TajwalURL;
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, FlightsSearchService + origin + "-" + destination + "/"
                + flightDate + "/" + flightClass + "/" + passengers);

        return response;
    }
}
