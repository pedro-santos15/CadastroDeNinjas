package dev.java10x.CadastroDeNinjas.Ninjas.mapper;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO dto){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(dto.getId());
        ninjaModel.setNome(dto.getNome());
        ninjaModel.setEmail(dto.getEmail());
        ninjaModel.setRank(dto.getRank());
        ninjaModel.setMissoes(dto.getMissoes());
        ninjaModel.setImgUrl(dto.getImgUrl());
        ninjaModel.setIdade(dto.getIdade());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setIdade(ninjaModel.getIdade());

        return ninjaDTO;
    }
}
