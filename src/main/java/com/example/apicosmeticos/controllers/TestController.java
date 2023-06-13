package com.example.apicosmeticos.controllers;

import jakarta.persistence.PreRemove;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class TestController {
    @GetMapping
    public String saludo(){
        return new String("Hola");
    }
}
