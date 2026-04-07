package dev.java10x.CadastroDeNinjas.Missoes.service;

import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository repository;

    public MissoesService(MissoesRepository repository) {
        this.repository = repository;
    }

    public List<MissoesModel> listarMissoes(){
        return repository.findAll();
    }

    public MissoesModel buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missao){
        return repository.save(missao);
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missao){
        if (repository.existsById(id)){
            missao.setId(id);
            return repository.save(missao);
        }

        return null;
    }

    public void deletarMissaoPorId(Long id){
        repository.deleteById(id);
    }


}
