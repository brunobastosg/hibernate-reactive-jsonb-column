package io.quarkus.mcve.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.mcve.entity.Example;

@ApplicationScoped
public class ExampleRepository implements PanacheRepositoryBase<Example, Integer> {

}
