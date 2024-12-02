package dev.java.CadastroDeNinjas.Missoes;


import dev.java.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Criar uma nova missao
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    // Listar todos as Missoes findAll -> SELECT
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .toList();
    }

    // Listar Missoes por ID
    public MissoesDTO listarMissoesPorId(long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    // alterar dados das Missoes
    public MissoesDTO alterarDadosDasMissoes(Long id, MissoesDTO missoesAlterada) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missoesAtualizada = missoesMapper.map(missoesAlterada);
            missoesAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missoesAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    // deletar missoes
    public void deletarMissoesPorId (Long id){
        missoesRepository.deleteById(id);
    }
}
