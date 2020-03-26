package com.br.desafio.banco.mapper;

import org.mapstruct.Mapper;

import com.br.desafio.banco.domain.ContaCorrente;
import com.br.desafio.banco.dto.ContaCorrenteDTO;

@Mapper(componentModel = "spring")
public interface ContaCorrenteMapper {

    public ContaCorrenteDTO contaCorrenteToContaCorrenteDTO(ContaCorrente contaCorrente);
    public ContaCorrente contaCorrenteDTOToContaCorrente(ContaCorrenteDTO DTO);
}
