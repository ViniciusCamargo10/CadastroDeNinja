package dev.java.CadastroDeNinjas.Ninjas.Controller.Service;


import org.hibernate.query.named.NameableQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinja() {
        List<NinjaModel> ninjas = ninjaRepository.findAll(); // Obtemos todos os ninjas
        List<NinjaDTO> ninjaDTOs = new ArrayList<>(); // Criamos uma lista para os DTOs

        for (NinjaModel ninja : ninjas) { // Iteramos pelos modelos
            NinjaDTO ninjaDTO = ninjaMapper.map(ninja); // Mapeamos o modelo para DTO
            ninjaDTOs.add(ninjaDTO); // Adicionamos o DTO na lista
        }
        return ninjaDTOs; // Retornamos a lista de DTOs
    }

    // Listar Ninja Por id
    public NinjaDTO listarNinjaPorId(Long Id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(Id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO atualizarNinjaPorId(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
