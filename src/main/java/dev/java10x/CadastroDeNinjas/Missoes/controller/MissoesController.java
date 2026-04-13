package dev.java10x.CadastroDeNinjas.Missoes.controller;

import dev.java10x.CadastroDeNinjas.Missoes.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.service.MissoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lista todas as missões",
            description = "Lista todas as missões cadastradas no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missões retornadas com sucesso")
    })
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        return ResponseEntity.ok(service.listarMissoes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontra missão por ID",
            description = "Retorna missão baseada no ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada (Not Found)")
    })
    public ResponseEntity<?> buscarMissaoPorId(
            @Parameter(description = "Usuário informa o ID no caminho da requisição")
            @PathVariable Long id) {
        MissoesDTO missaoEncontrada = service.buscarPorId(id);

        if (missaoEncontrada != null){
            return ResponseEntity.ok(missaoEncontrada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão para o ID " + id + " foi encontrada");
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missão",
            description = "Rota faz a criação de uma nova missão no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação de missão")
    })
    public ResponseEntity<String> criarMissao(
            @Parameter(description = "Usuário informa os dados da missão no body da requisição")
            @RequestBody MissoesDTO missao) {
        MissoesDTO missaoCriada = service.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão foi criada com sucesso!");
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza os dados de uma missão",
            description = "Rota faz a atualização de uma missão existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada(Not Found)")
    })
    public ResponseEntity<?> atualizarMissao(
            @Parameter(description = "Usuário informa o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário informa os dados da missão no body da requisição")
            @RequestBody MissoesDTO missao) {
        MissoesDTO missaoEncontrada = service.atualizarMissao(id, missao);

        if (missaoEncontrada != null){
            return ResponseEntity.ok(missaoEncontrada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão para o ID " + id + " foi encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleção de Missão por ID",
            description = "Rota deleta uma missão do banco de dados baseado no ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada(Not found)")
    })
    public ResponseEntity<String> deletarMissaoPorId(
            @Parameter(description = "Usuário informa o ID no caminho da requisição")
            @PathVariable Long id) {

        if (buscarMissaoPorId(id) != null){
            service.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão de ID " + id + " foi deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão para o ID " + id + " foi encontrada");
        }
    }
}
