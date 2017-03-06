package edu.matc.entity;

/**
 * Created by Punitha Anandan on 3/4/2017.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.matc.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Path("/hello")
public class HelloWorld {
    private final Logger log = Logger.getLogger(this.getClass());

    @GET

    @Produces("application/json")

    public Response getMessage() throws IOException {
        // Return a simple message
        //String output = "Hello " + message;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        UserDao userDao = new UserDao();
        List userList = (ArrayList<User>)userDao.getAllUsers();
        String arrayToJson = null;

        try {
            arrayToJson = mapper.writeValueAsString(userList);
        } catch (JsonProcessingException jsonProcessingException) {
            log.info("JsonProcessingException",jsonProcessingException);
        }
        return Response.status(200).entity(arrayToJson).build();
    }

}
