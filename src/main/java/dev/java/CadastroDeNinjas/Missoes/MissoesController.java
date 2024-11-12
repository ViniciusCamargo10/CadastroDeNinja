package dev.java.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    // get devolver para o usuario ( mostrar)
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes Listadas com sucesso";
    }
    // criar com post
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao Criada com sucesso";
    }
    // alterar com put
    @PutMapping("/alterarMissao")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }
    // deletar com delete
    @DeleteMapping("/deletar")
    public String deletarMissao (){
        return "Missao deletada com sucesso";
    }

}
