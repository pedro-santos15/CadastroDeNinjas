package dev.java10x.CadastroDeNinjas.Ninjas.service;

import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository repository;


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

    public NinjaModel criarNinja(NinjaModel ninja){
        return repository.save(ninja);
    }

}
