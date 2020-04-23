package org.acme.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;


@Path("/hello-hibernate")
public class GreetingResourceHibernate {

    @Inject
    EntityManager entityManager;

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam Integer id){
        Hello hello = entityManager.find(Hello.class, id);
        if (hello == null) {
            throw new WebApplicationException("Hello with id of " + id + " does not exist.", 404);
        }
        return hello.getName();
    }

}