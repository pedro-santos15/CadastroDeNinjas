package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem Vindo ao cadastro de ninjas";
    }

    //Adicionar ninja (POST) (CREATE)
    @PostMapping("/criar")
    public String adicionarNinja(){
        return "Ninja criado";
    }

    //findById (GET) (READ)
    @GetMapping("/{id}")
    public String buscaNinjaPorId(@PathVariable Long id){
        return "Ninja encontrado neste id: ";
    }
    //Mostrar todos os ninjas (GET) (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Todos os ninjas";
    }
    //Atualizar Ninja (PUT) (UPDATE)
    @PutMapping("/atualizar")
    public String atualizarNinja(){
        return "Ninja Atualziado";
    }
    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado";
    }


}
