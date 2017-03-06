package edu.matc.entity;

/**
 * Created by Punitha Anandan on 3/4/2017.
 */

import edu.matc.persistence.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/hello")
public class HelloWorld {

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")

    public Response getMessage() {
        // Return a simple message
        //String output = "Hello " + message;
        UserDao userDao = new UserDao();

        List userList = (ArrayList<User>)userDao.getAllUsers();
        return Response.status(200).entity(userList).build();
    }
}
