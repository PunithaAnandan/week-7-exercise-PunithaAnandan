package edu.matc.testrest;

/**
 * Created by Punitha Anandan on 3/4/2017.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloWorld {
    @Path("/plain")
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")

    public Response getPlainMessage() {
        // Return a simple message
        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }

    @Path("/html")
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    public Response getHtmlMessage() {
        // Return a simple message
        String output = "<b>Hello World</b>";
        return Response.status(200).entity(output).build();
    }

    @Path("/json")
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")

    public Response getMessage() {
        // Return a simple message
        //String output = "Hello " + message;
        User user = new User();
        user.setFirstName("Tom");
        user.setLastName("Tin");
        return Response.status(200).entity(user).build();
    }
}
