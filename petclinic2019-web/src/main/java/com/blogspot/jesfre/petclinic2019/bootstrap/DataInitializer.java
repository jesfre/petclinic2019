package com.blogspot.jesfre.petclinic2019.bootstrap;

import com.blogspot.jesfre.petclinic2019.model.Owner;
import com.blogspot.jesfre.petclinic2019.model.Vet;
import com.blogspot.jesfre.petclinic2019.services.OwnerService;
import com.blogspot.jesfre.petclinic2019.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading owners...");
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Abel");
        owner1.setLastName("Ardo");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Peti");
        owner2.setLastName("Rojo");
        ownerService.save(owner2);

        System.out.println("Loading vets...");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vete");
        vet1.setLastName("Rinario");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Animal");
        vet2.setLastName("Doc");
        vetService.save(vet2);

        System.out.println("Data loaded.");
    }
}
