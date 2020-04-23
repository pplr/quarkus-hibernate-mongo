package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.bson.Document;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;

@Path("/hello-mongo")
public class GreetingResourceMongo {

    @Inject MongoClient mongoClient;

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam String id){
        Document hello = mongoClient.getDatabase("hello").getCollection("hello").find(Filters.eq("_id", id)).first();
        if (hello == null) {
            throw new WebApplicationException("Hello with id of " + id + " does not exist.", 404);
        }
        return hello.getString("name");
    }

}