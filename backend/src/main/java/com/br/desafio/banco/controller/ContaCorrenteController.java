package com.br.desafio.banco.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafio.banco.dto.ContaCorrenteDTO;
import com.br.desafio.banco.service.ContaCorrenteService;

@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {

    private ContaCorrenteService  contaCorrenteService;

    @Autowired
    public ContaCorrenteController(ContaCorrenteService contaCorrenteService) {
        super();
        this.contaCorrenteService = contaCorrenteService;
    }
    
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContaCorrenteDTO getContaCorrente(@PathVariable("id") @NotNull Long id) {
       return contaCorrenteService.buscarPorId(id);
    }
    
    @GetMapping(value = "/saldo/{agencia}/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float getSaldo(@PathVariable("agencia") @NotNull String agencia, @PathVariable("codigo") @NotNull String codigo) {
        return contaCorrenteService.buscarSaldoPorAgenciaECodigo(agencia, codigo);
    }
    
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContaCorrenteDTO> getContasCorrentes() {
        return contaCorrenteService.buscarTodas(); 
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContaCorrenteDTO criar(@RequestBody @Validated  ContaCorrenteDTO dto) {
        return contaCorrenteService.criar(dto);
    }
    
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ContaCorrenteDTO atualizar(@RequestBody @Validated  ContaCorrenteDTO dto, @PathVariable("id") Long id) {
        return contaCorrenteService.atualizar(dto, id);
    }
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluir(@PathVariable("id") @NotNull Long id) {
        contaCorrenteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    
}
