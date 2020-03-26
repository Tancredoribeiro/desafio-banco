package com.br.desafio.banco.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.br.desafio.banco.domain.ContaCorrente;
import com.br.desafio.banco.dto.ContaCorrenteDTO;

public interface ContaCorrenteService {

    ContaCorrenteDTO criar(ContaCorrenteDTO dto);

    ContaCorrenteDTO atualizar(ContaCorrenteDTO dto, Long id);

    ContaCorrenteDTO buscarPorId(@NotNull Long id);

    List<ContaCorrenteDTO> buscarTodas();

    void excluir(@NotNull Long id);

    ContaCorrente buscarPorAgenciaECodigo(String agencia, String codigo);

    ContaCorrente atualizar(ContaCorrente contaCorrente);

    Float buscarSaldoPorAgenciaECodigo( String agencia,  String codigo);

}
