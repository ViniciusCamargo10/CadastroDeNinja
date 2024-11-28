package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;


import org.hibernate.query.named.NameableQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas findAll -> SELECT
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();
    }

    // Listar Ninja Por id
    public NinjaModel listarNinjaPorId(Long Id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(Id);
        return ninjaPorId.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar Ninja Por id
    public void deletarNinjaPorId (Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja Por id
    public NinjaModel atualizarNinjaPorId(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
