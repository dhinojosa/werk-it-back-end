package com.xyzcorp.domain.services;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Inject
    EntityManager entityManager;

    @GET()
    @Path("/{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloToUser(@PathParam("username") String username, @PathParam("password") String password) {
        if (username.equals("admin") && password.equals("pilot")) {
            //Negotiate with business service
            //Then the business service would talk to the database through DAO
            return Response.ok().build();
        }
        return Response.status(401).build();
    }
}
