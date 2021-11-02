package com.fabio.hexagonalapi.adapters.controllers;


import com.fabio.hexagonalapi.adapters.dtos.PersonDTO;
import com.fabio.hexagonalapi.application.domain.Person;
import com.fabio.hexagonalapi.application.ports.PersonServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    @Autowired
    PersonServicePort personServicePort;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody @Valid PersonDTO personDTO){
        Person person = modelMapper.map(personDTO,Person.class);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(modelMapper.map(personServicePort.save(person),PersonDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        List<Person> personsList = personServicePort.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(personsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonDTO>> findById(@PathVariable Long id){
        Optional<Person> person = personServicePort.findById(id);
        Optional<PersonDTO> personDTO = person.map(p -> modelMapper.map(p,PersonDTO.class));
        return ResponseEntity.status(HttpStatus.OK).body(personDTO);
    }
}
