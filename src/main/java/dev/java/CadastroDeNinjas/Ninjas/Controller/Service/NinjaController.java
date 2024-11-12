package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinja(){
        return ninjaService.listarNinja();
    }

    // mostrar ninjas por id
    @GetMapping("/listarPorId")
    public String listarNinjaPorId(){
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
