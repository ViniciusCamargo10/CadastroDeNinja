package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.java.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;

// transforma a class em entidade (Banco de dados)
@Entity

// cria tabela cadastro
@Table(name = "tb_cadastro")

// Construtores (Lombok)
@NoArgsConstructor
@AllArgsConstructor

// cria getters and setters
@Data
public class NinjaModel {

    // para o java saber como adicionar o id do usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    // o email tem que ser unico
    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    // @ManyToOne - um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // chave estrangeira
    private MissoesModel missoes;

}

