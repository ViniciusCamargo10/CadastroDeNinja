package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;


import org.hibernate.query.named.NameableQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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
