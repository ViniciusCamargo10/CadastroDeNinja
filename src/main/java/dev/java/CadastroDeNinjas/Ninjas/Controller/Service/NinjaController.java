package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "essa é minha primeira mensagem";
    }

    // adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // mostrar todos os ninjas
    @GetMapping("/todos")
    public  String mostrarNinjas(){
        return "Mostar Ninjas";
    }

    // mostrar ninjas por id
    @GetMapping("/todosPorId")
    public String mostrarNinjaPorId(){
        return "Mostar Ninja por id";
    }

    // alterar dados dos ninjas
    @PutMapping("/alterarId")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por id";
    }

    // deletar ninja
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }


}
