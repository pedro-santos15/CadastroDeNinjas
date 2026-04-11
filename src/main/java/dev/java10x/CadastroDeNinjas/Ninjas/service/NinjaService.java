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

    private final NinjaRepository repository;
    private final NinjaMapper mapper;

    public NinjaService(NinjaRepository repository, NinjaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Listar todos os ninjas

    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = repository.findAll();
        return ninjas.stream()
                .map(mapper::map)
                .toList();
    }

    public NinjaDTO buscaNinjaPorId(Long id){
        Optional<NinjaModel> ninjaModel = repository.findById(id);
        return ninjaModel.map(mapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = mapper.map(ninjaDTO);
        ninja = repository.save(ninja);
        return mapper.map(ninja);

    }

    public void deletarNinjaPorId(Long id){
        repository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO dto){
        Optional<NinjaModel> ninjaModel = repository.findById(id);

        if (ninjaModel.isPresent()){
            NinjaModel ninjaAtualizado = mapper.map(dto);
            ninjaAtualizado.setId(id);

            NinjaModel ninjaSalvo = repository.save(ninjaAtualizado);
            return mapper.map(ninjaSalvo);
        }

        return null;
    }

}
