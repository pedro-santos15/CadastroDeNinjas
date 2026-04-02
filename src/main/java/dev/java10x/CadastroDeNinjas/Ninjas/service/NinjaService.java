package dev.java10x.CadastroDeNinjas.Ninjas.service;

import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
