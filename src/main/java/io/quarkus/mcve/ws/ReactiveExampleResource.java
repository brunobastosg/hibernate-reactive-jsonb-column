package io.quarkus.mcve.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.mcve.entity.Example;
import io.quarkus.mcve.repository.ExampleRepository;
import io.smallrye.mutiny.Uni;

@Path("/example")
public class ReactiveExampleResource {

    @Inject
    ExampleRepository repository;
    
    // docker run -d --name mcve-db -e POSTGRES_USER=mcve -e POSTGRES_PASSWORD=mcve -e POSTGRES_DB=mcve -p 5432:5432 postgres:13
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Example> insert(Example example) {
        return Panache.withTransaction(() -> repository.persist(example));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Example>> findAll() {
        return repository.listAll();
    }
}