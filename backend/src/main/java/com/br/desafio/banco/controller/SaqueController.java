package com.br.desafio.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafio.banco.dto.SaqueDTO;
import com.br.desafio.banco.service.SaqueService;

@RestController
@RequestMapping("/saques")
public class SaqueController {

    private SaqueService saqueService;

    @Autowired
    public SaqueController(SaqueService saqueService) {
        super();
        this.saqueService = saqueService;
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sacar(@RequestBody @Validated SaqueDTO dto) {
        return saqueService.sacar(dto);
        
    }
    
    
}
