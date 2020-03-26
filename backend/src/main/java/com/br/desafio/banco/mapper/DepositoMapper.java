package com.br.desafio.banco.mapper;

import org.mapstruct.Mapper;

import com.br.desafio.banco.domain.Deposito;
import com.br.desafio.banco.dto.DepositoDTO;

@Mapper(componentModel = "spring")
public interface DepositoMapper {
    
    public DepositoDTO depositoToDepositoDTO(Deposito deposito);
    public Deposito depositoDTOToDeposito(DepositoDTO DTO);
}
