package com.br.desafio.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafio.banco.dto.DepositoDTO;
import com.br.desafio.banco.service.DepositoService;

@RestController
@RequestMapping("/depositos")
public class DepositoController {

    private DepositoService depositoService;
    
    
    
    @Autowired
    public DepositoController(DepositoService depositoService) {
        super();
        this.depositoService = depositoService;
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> depositar(@RequestBody @Validated DepositoDTO dto) {
        return depositoService.depositar(dto);
    }
}
