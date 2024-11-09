package dev.java.CadastroDeNinjas.Missoes;

import dev.java.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificudade;

    // @OneToMany - uma missao pode ter muitos ninjas
    // mappedBy - mapear as tabelas
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel> ninjas;


}

