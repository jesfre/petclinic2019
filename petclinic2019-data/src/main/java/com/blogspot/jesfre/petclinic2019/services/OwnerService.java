package com.blogspot.jesfre.petclinic2019.services;

import com.blogspot.jesfre.petclinic2019.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
