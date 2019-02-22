package com.blogspot.jesfre.petclinic2019.bootstrap;

import com.blogspot.jesfre.petclinic2019.model.*;
import com.blogspot.jesfre.petclinic2019.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitiesService;
    private final VisitService visitService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Loading pet types...");
        PetType dogType = new PetType();
        dogType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(catType);

        System.out.println("Loading specialities...");
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        System.out.println("Loading owners...");
        Owner owner1 = new Owner();
        owner1.setFirstName("Abel");
        owner1.setLastName("Ardo");

        System.out.println("Building dog.");
        Pet abelsPet = new Pet();
        abelsPet.setName("Firus");
        abelsPet.setPetType(savedDogPetType);
        abelsPet.setOwner(owner1);
        abelsPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(abelsPet);
        owner1 = ownerService.save(owner1);
        System.out.println("Saved owner with Id#"+owner1.getId());

        Owner owner2 = new Owner();
        owner2.setFirstName("Peti");
        owner2.setLastName("Rojo");

        System.out.println("Building cat.");
        Pet petisPet = new Pet();
        petisPet.setName("Firus");
        petisPet.setPetType(savedCatPetType);
        petisPet.setOwner(owner2);
        petisPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(petisPet);
        ownerService.save(owner2);
        System.out.println("Saved owner with Id#"+owner2.getId());

        Visit petisVisit = new Visit();
        petisVisit.setPet(petisPet);
        petisVisit.setDate(LocalDate.now());
        petisVisit.setDescription("Very sick!");
        visitService.save(petisVisit);

        System.out.println("Loading vets...");
        Vet vet1 = new Vet();
        vet1.setFirstName("Vete");
        vet1.setLastName("Rinario");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);
        System.out.println("Saved vet with Id#"+vet1.getId());

        Vet vet2 = new Vet();
        vet2.setFirstName("Animal");
        vet2.setLastName("Doc");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Saved vet with Id#"+vet2.getId());

        System.out.println("Data loaded.");
    }
}
