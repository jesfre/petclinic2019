package com.blogspot.jesfre.petclinic2019.services;

import com.blogspot.jesfre.petclinic2019.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
