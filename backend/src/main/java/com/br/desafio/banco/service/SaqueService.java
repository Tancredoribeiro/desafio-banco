package com.br.desafio.banco.service;

import org.springframework.http.ResponseEntity;

import com.br.desafio.banco.dto.SaqueDTO;

public interface SaqueService {

    ResponseEntity<?> sacar(SaqueDTO dto);

}
