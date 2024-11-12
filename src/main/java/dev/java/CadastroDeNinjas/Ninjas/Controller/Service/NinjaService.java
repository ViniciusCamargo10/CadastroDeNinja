package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.stereotype.Service;

import java.util.List;

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



}
