package com.xyzcorp.domain.services;

import com.xyzcorp.domain.models.Aerobics;
import com.xyzcorp.domain.models.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/aerobics")
public class AerobicResource {

    @Inject
    EntityManager entityManager;

    @POST()
    @Path("/user/{userid}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Aerobics aerobics, @PathParam("userid") Long id) {
        User user = entityManager.find(User.class, id);
        aerobics.setUser(user);
        entityManager.persist(aerobics);
        return Response.ok(aerobics).build();
    }

    @GET
    @Path("/user/{userid}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUserId(@PathParam("userid") Long userId) {
        TypedQuery<Aerobics> query = entityManager.createQuery("SELECT a FROM" +
            " Aerobics a WHERE a.user.id = :user_id", Aerobics.class);
        List<Aerobics> aerobicsList = query
            .setParameter("user_id", userId)
            .getResultList();
        System.out.println(aerobicsList);
        return Response.ok(aerobicsList).build();
    }

}
