package com.blogspot.jesfre.petclinic2019.services.map;

import com.blogspot.jesfre.petclinic2019.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    private static final Long OWNER_ID = 1L;
    public static final String LAST_NAME = "Ruiz";

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(new Owner(OWNER_ID, null, LAST_NAME, null, null, null, null));
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long newId = 2L;
        Owner owner2 = Owner.builder().build();
        owner2.setId(newId);
        Owner saved = ownerMapService.save(owner2);

        assertEquals(newId, saved.getId());
    }

    @Test
    void saveNoId() {
        Owner saved = ownerMapService.save(Owner.builder().build());
        assertNotNull(saved);
        assertNotNull(saved.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(LAST_NAME);

        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("find this");

        assertNull(owner);
    }
}