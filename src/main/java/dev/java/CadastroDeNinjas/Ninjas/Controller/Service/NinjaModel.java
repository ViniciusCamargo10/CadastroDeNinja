package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.java.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// transforma a class em entidade (Banco de dados)
@Entity

// criar tabela cadastro
@Table(name = "tb_cadastro")

public class NinjaModel {

    // para o java saber como adicionar o id do usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne - um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // chave estrangeira
    private MissoesModel missoes;


    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

