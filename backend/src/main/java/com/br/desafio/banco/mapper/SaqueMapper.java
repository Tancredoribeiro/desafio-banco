package com.br.desafio.banco.mapper;

import org.mapstruct.Mapper;

import com.br.desafio.banco.domain.Saque;
import com.br.desafio.banco.dto.SaqueDTO;

@Mapper(componentModel = "spring")
public interface SaqueMapper {
    
    public SaqueDTO saqueToSaqueDTO(Saque saque);
    public Saque saqueDTOToSaque(SaqueDTO dto);
}
