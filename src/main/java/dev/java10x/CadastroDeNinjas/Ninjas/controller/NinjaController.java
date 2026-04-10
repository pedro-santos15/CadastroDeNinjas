package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja = service.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    //findById (GET) (READ)
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaNinjaPorId(@PathVariable Long id){
        NinjaDTO ninjaEncontrado = service.buscaNinjaPorId(id);

        if (ninjaEncontrado != null){
            return ResponseEntity.ok(ninjaEncontrado);
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja com ID " + id + " não foi encontrado nos nossos registros");
        }
    }

    //Mostrar todos os ninjas (GET) (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
       List<NinjaDTO> ninjas = service.listarNinjas();
       return ResponseEntity.ok(ninjas);
    }

    //Atualizar Ninja (PUT) (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        if (service.buscaNinjaPorId(id) != null){
            NinjaDTO ninjaAtualizado = service.atualizarNinja(id, ninja);

            return ResponseEntity.ok(ninjaAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não foi encontrado para atualização");
        }
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if (service.buscaNinjaPorId(id) != null){
            service.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não foi encontrado para deleção");
        }

    }


}
