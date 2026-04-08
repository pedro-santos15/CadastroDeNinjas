package dev.java10x.CadastroDeNinjas.Ninjas.dto;

import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String imgUrl;
    private MissoesModel missoes;
    private String rank;
}
