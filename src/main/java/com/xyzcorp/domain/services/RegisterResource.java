package com.xyzcorp.domain.services;

import com.xyzcorp.domain.models.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/register")
public class RegisterResource {

    @Inject
    EntityManager entityManager;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        entityManager.persist(user);
        return Response.ok(user).build();
    }
}
