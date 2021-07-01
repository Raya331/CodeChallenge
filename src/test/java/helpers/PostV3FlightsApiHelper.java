package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostV3FlightsApiHelper {

    private static String TajwalURL = "https://www.tajawal.com";
    private static String FlightsSyncSearchService = "/api/v3/flights/flight/async-search-result";

    public static Response postV3Flights(String origin, String destination, String flightDate, String flightClass,
                                         String passengers) {

        RestAssured.baseURI = TajwalURL;

        String requestPayload ="{\n" +
                "   \"next\":{\n" +
                "      \"nid\":\"1625166839401302593\",\n" +
                "      \"get\":[\n" +
                "         {\n" +
                "            \"cid\":\"2f8adf43\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tpt-uae\",\n" +
                "               \"code\":\"TPT\",\n" +
                "               \"chnr\":0\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"61e16031\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"FZ\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"f9341b75\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"XY\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"c27dad38\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"G9\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"c4ca75da\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"E5\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"3870bd8c\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"J9\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"69d8ad3c\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"OV\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"d60283bd\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"AI\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"6f7badf7\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"3L\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"20b4ef4f\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"FT\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"4f269a0e\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"W6\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"cid\":\"3db3b192\",\n" +
                "            \"info\":{\n" +
                "               \"uid\":\"cont-tf-uae\",\n" +
                "               \"code\":\"TFN\",\n" +
                "               \"chnr\":\"5W\"\n" +
                "            }\n" +
                "         }\n" +
                "      ],\n" +
                "      \"let\":[\n" +
                "         \n" +
                "      ],\n" +
                "      \"hashedKey\":\"4ca34266d53e97c0f550ceb76f8d5076\"\n" +
                "   },\n" +
                "   \"request\":{\n" +
                "      \"leg\":[\n" +
                "         {\n" +
                "            \"index\":0,\n" +
                "            \"originId\":\""+origin+"\",\n" +
                "            \"destinationId\":\""+destination+"\",\n" +
                "            \"departure\":\""+flightDate+"\",\n" +
                "            \"nearByOriginId\":false,\n" +
                "            \"nearByDestinationId\":false,\n" +
                "            \"preferredCabin\":\""+flightClass+"\",\n" +
                "            \"nonstop\":false\n" +
                "         }\n" +
                "      ],\n" +
                "      \"searchType\":\"Oneway\",\n" +
                "      \"isRoundTrip\":false,\n" +
                "      \"preferredAirline\":[\n" +
                "         \n" +
                "      ],\n" +
                "      \"pax\":{\n" +
                "         \"adult\":1,\n" +
                "         \"totalSeats\":1,\n" +
                "         \"child\":0,\n" +
                "         \"infant\":0\n" +
                "      },\n" +
                "      \"query\":\""+origin+"-"+destination+"/"+flightDate+"/"+flightClass+"/"+passengers+"\",\n" +
                "      \"cabin\":\"Economy\"\n" +
                "   }\n" +
                "}";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");

        return httpRequest.body(requestPayload).post(FlightsSyncSearchService);
    }
}
