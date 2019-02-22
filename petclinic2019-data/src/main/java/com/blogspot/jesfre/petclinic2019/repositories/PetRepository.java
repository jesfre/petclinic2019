package com.blogspot.jesfre.petclinic2019.repositories;

import com.blogspot.jesfre.petclinic2019.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
