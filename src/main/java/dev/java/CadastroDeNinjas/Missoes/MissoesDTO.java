package dev.java.CadastroDeNinjas.Missoes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;
}
