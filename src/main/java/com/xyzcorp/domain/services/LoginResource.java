package com.xyzcorp.domain.services;

import com.xyzcorp.domain.models.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/login")
public class LoginResource {

    @Inject
    EntityManager entityManager;

    @GET()
    @Path("/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("username") String username,
                          @PathParam("password") String password) {
        TypedQuery<User> query = entityManager.createQuery("Select u from " +
            "User as u " +
            "where u.username = :username and u.password = :password",
            User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> resultList = query.setMaxResults(1).getResultList();
        if (resultList.isEmpty()) return Response.status(401).build();
        return Response.ok(resultList.get(0)).build();
    }
}
