package com.fabio.hexagonalapi.application.services;

import com.fabio.hexagonalapi.application.domain.Person;
import com.fabio.hexagonalapi.application.ports.PersonRepositoryPort;
import com.fabio.hexagonalapi.application.ports.PersonServicePort;


import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonServicePort {

    private final PersonRepositoryPort personRepositoryPort;

    public PersonServiceImpl(final PersonRepositoryPort personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }


    @Override
    public Person save(Person person) {
        return personRepositoryPort.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepositoryPort.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepositoryPort.findById(id);
    }
}
