package com.blogspot.jesfre.petclinic2019.controllers;

import com.blogspot.jesfre.petclinic2019.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/home", "/home.html"})
    public String ownerList(Model model) {
        model.addAttribute("ownerList", ownerService.findAll());
        return "owners/owners";
    }

}
