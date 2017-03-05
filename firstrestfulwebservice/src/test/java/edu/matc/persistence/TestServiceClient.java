package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.geocoder.Results;
import com.google.geocoder.ResultsItem;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static junit.framework.TestCase.assertEquals;


public class TestServiceClient {

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://maps.googleapis.com/maps/api/geocode/json?" +
                        "address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=false");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(response,Results.class);
        ResultsItem result = results.getResults().get(0);
        assertEquals(37.4224267,result.getGeometry().getLocation().getLat(),0);
        /*assertEquals("{\n" +
                "   \"results\" : [\n" +
                "      {\n" +
                "         \"address_components\" : [\n" +
                "            {\n" +
                "               \"long_name\" : \"1600\",\n" +
                "               \"short_name\" : \"1600\",\n" +
                "               \"types\" : [ \"street_number\" ]\n" +
                "            },\n" +
                "            {\n" +
                "               \"long_name\" : \"Amphitheatre Parkway\",\n" +
                "               \"short_name\" : \"Amphitheatre Pkwy\",\n" +
                "               \"types\" : [ \"route\" ]\n" +
                "            },\n" +
                "            {\n" +
                "               \"long_name\" : \"Mountain View\",\n" +
                "               \"short_name\" : \"Mountain View\",\n" +
                "               \"types\" : [ \"locality\", \"political\" ]\n" +
                "            },\n" +
                "            {\n" +
                "               \"long_name\" : \"Santa Clara County\",\n" +
                "               \"short_name\" : \"Santa Clara County\",\n" +
                "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
                "            },\n" +
                "            {\n" +
                "               \"long_name\" : \"California\",\n" +
                "               \"short_name\" : \"CA\",\n" +
                "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
                "            },\n" +
                "            {\n" +
                "               \"long_name\" : \"United States\",\n" +
                "               \"short_name\" : \"US\",\n" +
                "               \"types\" : [ \"country\", \"political\" ]\n" +
                "            },\n" +
                "            {\n" +
                "               \"long_name\" : \"94043\",\n" +
                "               \"short_name\" : \"94043\",\n" +
                "               \"types\" : [ \"postal_code\" ]\n" +
                "            }\n" +
                "         ],\n" +
                "         \"formatted_address\" : \"1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA\",\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 37.4224267,\n" +
                "               \"lng\" : -122.0842499\n" +
                "            },\n" +
                "            \"location_type\" : \"ROOFTOP\",\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 37.4237756802915,\n" +
                "                  \"lng\" : -122.0829009197085\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 37.4210777197085,\n" +
                "                  \"lng\" : -122.0855988802915\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"place_id\" : \"ChIJ2eUgeAK6j4ARbn5u_wAGqWA\",\n" +
                "         \"types\" : [ \"street_address\" ]\n" +
                "      }\n" +
                "   ],\n" +
                "   \"status\" : \"OK\"\n" +
                "}\n", response);*/
    }
}