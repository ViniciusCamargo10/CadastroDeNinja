package dev.java.CadastroDeNinjas.Missoes;

import dev.java.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    // @OneToMany - uma missao pode ter muitos ninjas
    // mappedBy - mapear as tabelas
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel> ninjas;


}

