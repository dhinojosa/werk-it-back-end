package com.xyzcorp.domain.services;

import com.xyzcorp.domain.models.Aerobics;
import com.xyzcorp.domain.models.User;
import com.xyzcorp.domain.models.Weights;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/weights")
public class WeightResource {

    @Inject
    EntityManager entityManager;

    @POST()
    @Path("/user/{userid}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Weights weights, @PathParam("userid") Long id) {
        User user = entityManager.find(User.class, id);
        weights.setUser(user);
        entityManager.persist(weights);
        return Response.ok(weights).build();
    }

    @GET
    @Path("/user/{userid}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUserId(@PathParam("userid") Long userId) {
        TypedQuery<Weights> query = entityManager.createQuery("SELECT a FROM" +
            " Weights a WHERE a.user.id = :user_id", Weights.class);
        List<Weights> aerobicsList = query
            .setParameter("user_id", userId)
            .getResultList();
        System.out.println(aerobicsList);
        return Response.ok(aerobicsList).build();
    }
}
