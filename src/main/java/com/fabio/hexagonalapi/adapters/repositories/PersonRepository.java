package com.fabio.hexagonalapi.adapters.repositories;

import com.fabio.hexagonalapi.adapters.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
