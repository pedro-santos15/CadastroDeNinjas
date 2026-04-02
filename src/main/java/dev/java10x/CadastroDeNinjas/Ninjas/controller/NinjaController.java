package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

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
    public List<NinjaModel> listarNinjas(){
        return service.listarNinjas();
    }

    //Atualizar Ninja (PUT) (UPDATE)
    @PutMapping("/alterar")
    public String atualizarNinja(){
        return "Ninja Atualziado";
    }
    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId(){
        return "Ninja deletado";
    }


}
