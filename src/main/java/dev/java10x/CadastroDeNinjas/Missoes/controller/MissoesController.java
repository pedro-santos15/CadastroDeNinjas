package dev.java10x.CadastroDeNinjas.Missoes.controller;

import dev.java10x.CadastroDeNinjas.Missoes.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService service;

    public MissoesController(MissoesService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return service.listarMissoes();
    }

    @GetMapping("/{id}")
    public MissoesDTO buscarMissaoPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao) {
        return service.criarMissao(missao);
    }

    @PutMapping("/atualizar/{id}")
    public MissoesDTO atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        return service.atualizarMissao(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        service.deletarMissaoPorId(id);
        System.out.println("Missão Deletada");
    }
}
