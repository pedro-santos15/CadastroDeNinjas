package dev.java10x.CadastroDeNinjas.Ninjas.service;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository repository;
    private NinjaMapper mapper;


    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    //Listar todos os ninjas

    public List<NinjaModel> listarNinjas(){
        return repository.findAll();
    }

    public NinjaModel buscaNinjaPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = mapper.map(ninjaDTO);
        ninja = repository.save(ninja);
        return mapper.map(ninja);

    }

    public void deletarNinjaPorId(Long id){
        repository.deleteById(id);
    }

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaModel){
        if (repository.existsById(id)){
            ninjaModel.setId(id);
            return repository.save(ninjaModel);
        }

        return null;
    }

}
