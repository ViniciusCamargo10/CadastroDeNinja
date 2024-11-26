package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;

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


}
