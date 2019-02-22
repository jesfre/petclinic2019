package com.blogspot.jesfre.petclinic2019.repositories;

import com.blogspot.jesfre.petclinic2019.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
