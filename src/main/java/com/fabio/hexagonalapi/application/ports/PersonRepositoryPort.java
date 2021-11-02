package com.fabio.hexagonalapi.application.ports;

import com.fabio.hexagonalapi.application.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryPort {

    Person save(Person person);
    List<Person> findAll();
    Optional<Person> findById(Long id);

}
