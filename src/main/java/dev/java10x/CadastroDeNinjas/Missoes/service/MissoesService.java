package dev.java10x.CadastroDeNinjas.Missoes.service;

import dev.java10x.CadastroDeNinjas.Missoes.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.mapper.MissoesMapper;
import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final MissoesRepository repository;
    private final MissoesMapper mapper;

    public MissoesService(MissoesRepository repository, MissoesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = repository.findAll();
        return missoes.stream()
                .map(mapper::map)
                .toList();
    }

    public MissoesDTO buscarPorId(Long id){
        Optional<MissoesModel> missoesModel = repository.findById(id);

        return missoesModel.map(mapper::map).orElse(null);

    }

    public MissoesDTO criarMissao(MissoesDTO missao){
        MissoesModel missaoModel = mapper.map(missao);
        return mapper.map(repository.save(missaoModel));
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missao){
        Optional<MissoesModel> missaoEncontrada = repository.findById(id);

        if (missaoEncontrada.isPresent()){
            MissoesModel missoesModel = mapper.map(missao);
            missoesModel.setId(id);
            repository.save(missoesModel);

            return mapper.map(missoesModel);
        }

        return null;
    }

    public void deletarMissaoPorId(Long id){
        repository.deleteById(id);
    }


}
