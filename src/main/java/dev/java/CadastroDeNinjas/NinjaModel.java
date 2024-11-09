package dev.java.CadastroDeNinjas;

import jakarta.persistence.*;

// transforma a class em entidade (Banco de dados)
@Entity

// criar tabela cadastro
@Table(name = "tb_cadastro")

public class NinjaModel {

    // para o java saber como adicionar o id do usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }



}

