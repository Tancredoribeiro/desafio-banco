package com.br.desafio.banco.service;

import org.springframework.http.ResponseEntity;

import com.br.desafio.banco.dto.DepositoDTO;

public interface DepositoService {

    ResponseEntity<?> depositar(DepositoDTO dto);

}
