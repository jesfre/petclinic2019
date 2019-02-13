package com.blogspot.jesfre.petclinic2019.controllers;

import com.blogspot.jesfre.petclinic2019.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/home", "/home.html"})
    public String vetList(Model model) {
        model.addAttribute("vetList", vetService.findAll());
        return "vets/vets";
    }
}
