package com.xyzcorp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {

    @GET()
    @Path("/{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloToUser(@PathParam("username") String username) {
        return "Hello, username, password is verified";
    }
}
