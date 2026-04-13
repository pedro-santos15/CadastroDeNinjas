package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas",
            description = "Rota apresenta mensagem de boas vindas ao usuário que acessar")
    public String boasVindas(){
        return "Bem Vindo ao cadastro de ninjas";
    }

    //Adicionar ninja (POST) (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja",
            description = "Rota cria um novo ninja e o insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Usuário informa os dados do Ninja no Body da requisição")
            @RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja = service.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    //findById (GET) (READ)
    @GetMapping("/{id}")
    @Operation(summary = "Lista um ninja por ID",
            description = "Rota lista um ninja baseado no ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado (Not Found)")
    })
    public ResponseEntity<?> buscaNinjaPorId(
            @Parameter(description = "Usuário informa o ID no caminho da requisição")
            @PathVariable Long id){
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
    @Operation(summary = "Lista todos os ninjas",
            description = "Rota lista todos os ninjas cadastrados no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas retornados com sucesso")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
       List<NinjaDTO> ninjas = service.listarNinjas();
       return ResponseEntity.ok(ninjas);
    }

    //Atualizar Ninja (PUT) (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um ninja por ID",
            description = "Rota altera um ninja baseado no ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado (Not Found)")
    })
    public ResponseEntity<?> atualizarNinja(
            @Parameter(description = "Usuário informa o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário informa os dados do ninja no body da requisição")
            @RequestBody NinjaDTO ninja){

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
    @Operation(summary = "Deleção de Ninja por id",
            description = "Rota deleta um ninja do banco de dados baseado no ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuário informa o ID no caminho da requisição")
            @PathVariable Long id){

        if (service.buscaNinjaPorId(id) != null){
            service.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não foi encontrado para deleção");
        }

    }


}
