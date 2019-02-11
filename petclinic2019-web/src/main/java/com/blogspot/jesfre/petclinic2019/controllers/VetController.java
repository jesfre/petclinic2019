package com.blogspot.jesfre.petclinic2019.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    @RequestMapping({"", "/", "/home", "/home.html"})
    public String vetList() {
        return "vets/vets";
    }
}
