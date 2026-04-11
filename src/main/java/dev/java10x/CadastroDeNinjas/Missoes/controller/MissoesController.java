package dev.java10x.CadastroDeNinjas.Missoes.controller;

import dev.java10x.CadastroDeNinjas.Missoes.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService service;

    public MissoesController(MissoesService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        return ResponseEntity.ok(service.listarMissoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missaoEncontrada = service.buscarPorId(id);

        if (missaoEncontrada != null){
            return ResponseEntity.ok(missaoEncontrada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão para o ID " + id + " foi encontrada");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO missaoCriada = service.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão foi criada com sucesso!");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        MissoesDTO missaoEncontrada = service.atualizarMissao(id, missao);

        if (missaoEncontrada != null){
            return ResponseEntity.ok(missaoEncontrada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão para o ID " + id + " foi encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {

        if (buscarMissaoPorId(id) != null){
            service.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão de ID " + id + " foi deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão para o ID " + id + " foi encontrada");
        }
    }
}
