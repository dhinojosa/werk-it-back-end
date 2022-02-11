package com.xyzcorp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "You are user named Marc-Andre";
    }


    @GET()
    @Path("/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloToUser(@PathParam("username") String username) {
        return "Hello to you, " + username;
    }
}
