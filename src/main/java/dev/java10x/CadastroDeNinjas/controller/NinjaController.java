package dev.java10x.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem Vindo ao cadastro de ninjas";
    }

}
