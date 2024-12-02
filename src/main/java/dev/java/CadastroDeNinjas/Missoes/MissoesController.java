package dev.java.CadastroDeNinjas.Missoes;

import dev.java.CadastroDeNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    @Autowired
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // get devolver para o usuario ( mostrar)
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // criar com post
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoes){
        return missoesService.criarMissoes(missoes);

    }
    // alterar com put
    @PutMapping("/alterarMissao/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAlterada){
        return missoesService.alterarDadosDasMissoes(id, missaoAlterada);
    }

    // deletar missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
         missoesService.deletarMissoesPorId(id);
    }

}
