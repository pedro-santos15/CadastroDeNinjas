package dev.java10x.CadastroDeNinjas.Ninjas.model;

import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    //Muitos ninjas, podem ter uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // FK / Chave estrangeira
    private MissoesModel missoes;


}

