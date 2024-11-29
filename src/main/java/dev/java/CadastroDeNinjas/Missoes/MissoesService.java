package dev.java.CadastroDeNinjas.Missoes;


import dev.java.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService (MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Criar uma nova missao
    public MissoesModel criarMissoes(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

    // Listar todos as Missoes findAll -> SELECT
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Listar Missoes por ID
    public MissoesModel listarMissoesPorId(long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    // alterar dados das Missoes
    public MissoesModel alterarDadosDasMissoes(Long id, MissoesModel missoesAlterada) {
        if (missoesRepository.existsById(id)){
            missoesAlterada.setId(id);
            return missoesRepository.save(missoesAlterada);
        }
            return null;
    }

    // deletar missoes
    public void deletarMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }


}
