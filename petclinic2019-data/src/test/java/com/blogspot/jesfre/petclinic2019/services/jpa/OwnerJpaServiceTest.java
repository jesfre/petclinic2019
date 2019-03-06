package com.blogspot.jesfre.petclinic2019.services.jpa;

import com.blogspot.jesfre.petclinic2019.model.Owner;
import com.blogspot.jesfre.petclinic2019.repositories.OwnerRepository;
import com.blogspot.jesfre.petclinic2019.repositories.PetRepository;
import com.blogspot.jesfre.petclinic2019.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Ruiz";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService service;

    Owner testOwner;

    @BeforeEach
    void setUp() {
        testOwner = Owner.builder().build() ;
        testOwner.setId(1L);
        testOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        Mockito.when(service.findByLastName(ArgumentMatchers.any())).thenReturn(testOwner);

        Owner returnedOwner = service.findByLastName(LAST_NAME);

        assertEquals("Ruiz", returnedOwner.getLastName());

        Mockito.verify(ownerRepository).findByLastName(ArgumentMatchers.any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> returned = service.findAll();

        assertNotNull(returned);
        assertEquals(2, returned.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(testOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(testOwner);
        Owner saved = service.save(new Owner());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        service.delete(testOwner);
        service.delete(testOwner);

        verify(ownerRepository, times(2)).delete(any());

    }

    @Test
    void deleteById() {
        service.deleteById(testOwner.getId());
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}