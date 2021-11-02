package com.fabio.hexagonalapi.adapters.service;

import com.fabio.hexagonalapi.adapters.entities.PersonEntity;
import com.fabio.hexagonalapi.adapters.repositories.PersonRepository;
import com.fabio.hexagonalapi.application.domain.Person;
import com.fabio.hexagonalapi.application.ports.PersonRepositoryPort;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements PersonRepositoryPort {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = modelMapper.map(person,PersonEntity.class);
        personRepository.save(personEntity);
        return modelMapper.map(personEntity,Person.class);
    }

    @Override
    public List<Person> findAll() {
        List<PersonEntity> personsListEntity = personRepository.findAll();
        List<Person> personList = personsListEntity.stream()
                .map(entity -> modelMapper.map(entity,Person.class)).collect(Collectors.toList());
        return personList;

    }

    @Override
    public Optional<Person> findById(Long id) {
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        Optional<Person> person = personEntity.map( entity -> modelMapper.map(entity,Person.class));
        return person;
    }
}
