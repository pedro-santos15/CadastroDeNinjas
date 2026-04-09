package dev.java10x.CadastroDeNinjas.Missoes.mapper;

import dev.java10x.CadastroDeNinjas.Missoes.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {


    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel model = new MissoesModel();
        model.setId(missoesDTO.getId());
        model.setNome(missoesDTO.getNome());
        model.setDificuldade(missoesDTO.getDificuldade());
        model.setNinjas(missoesDTO.getNinjas());

        return model;
    }


    public MissoesDTO map(MissoesModel missoesModel){

        MissoesDTO dto = new MissoesDTO();
        dto.setId(missoesModel.getId());
        dto.setNome(missoesModel.getNome());
        dto.setDificuldade(missoesModel.getDificuldade());
        dto.setNinjas(missoesModel.getNinjas());

        return dto;
    }
}
