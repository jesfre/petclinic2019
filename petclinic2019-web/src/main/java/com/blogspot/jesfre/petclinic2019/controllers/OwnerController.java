package com.blogspot.jesfre.petclinic2019.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"", "/", "/home", "/home.html"})
    public String ownerList() {
        return "owners/owners";
    }

}
