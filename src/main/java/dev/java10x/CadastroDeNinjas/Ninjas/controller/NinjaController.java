package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return service.criarNinja(ninja);
    }

    //findById (GET) (READ)
    @GetMapping("/{id}")
    public NinjaModel buscaNinjaPorId(@PathVariable Long id){
        return service.buscaNinjaPorId(id);
    }

    //Mostrar todos os ninjas (GET) (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return service.listarNinjas();
    }

    //Atualizar Ninja (PUT) (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return service.atualizarNinja(id, ninja);
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        service.deletarNinjaPorId(id);
    }


}
