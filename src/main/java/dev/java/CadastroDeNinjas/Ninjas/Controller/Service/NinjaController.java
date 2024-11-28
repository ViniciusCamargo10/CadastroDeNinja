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
    @PostMapping("/Criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // mostrar todos os ninjas
    @GetMapping("/Listar")
    public List<NinjaModel> listarNinja() {
        return ninjaService.listarNinja();
    }

    // mostrar ninjas por id
    @GetMapping("/Listar/{Id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long Id) {
        return ninjaService.listarNinjaPorId(Id);
    }

    // alterar dados dos ninjas
    @PutMapping("/alterar/{Id}")
    public String alterarNinjaPorId() {
        return "Alterar Ninja por id";
    }

    // deletar ninja
    @DeleteMapping("/deletar/{Id}")
    public void deletarNinjaPorId(@PathVariable Long Id) {
        ninjaService.deletarNinjaPorId(Id);

    }

}
