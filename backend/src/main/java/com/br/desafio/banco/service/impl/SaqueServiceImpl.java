package com.br.desafio.banco.service.impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.desafio.banco.domain.ContaCorrente;
import com.br.desafio.banco.domain.Saque;
import com.br.desafio.banco.dto.SaqueDTO;
import com.br.desafio.banco.exception.SaldoInsufucienteException;
import com.br.desafio.banco.mapper.SaqueMapper;
import com.br.desafio.banco.repository.SaqueRepository;
import com.br.desafio.banco.service.ContaCorrenteService;
import com.br.desafio.banco.service.SaqueService;

@Service
public class SaqueServiceImpl implements SaqueService {

    private SaqueRepository saqueRepository;
    
    private ContaCorrenteService contaCorrenteService;
    
    private SaqueMapper saqueMapper;

    @Autowired
    public SaqueServiceImpl(SaqueRepository saqueRepository, ContaCorrenteService contaCorrenteService,
            SaqueMapper saqueMapper) {
        super();
        this.saqueRepository = saqueRepository;
        this.contaCorrenteService = contaCorrenteService;
        this.saqueMapper = saqueMapper;
    }


    @Transactional
    @Override
    public ResponseEntity<?> sacar(SaqueDTO dto) {
        ContaCorrente contaCorrente = contaCorrenteService.buscarPorAgenciaECodigo(dto.getAgencia(), dto.getConta());
        Saque saque = saqueMapper.saqueDTOToSaque(dto);
        if( saque.getValor() > contaCorrente.getSaldo()) {
            throw new SaldoInsufucienteException(String.format("Esta conta não possui saldo o sufuciente para realizar o saque neste valor: %s.", saque.getValor()));
        }
        
        saque.setContaCorrente(contaCorrente);
        saque.setData(LocalDateTime.now());
        saqueRepository.save(saque);
        
        Float novoSaldo = contaCorrente.getSaldo() - saque.getValor();
        contaCorrente.setSaldo(novoSaldo);
        contaCorrenteService.atualizar(contaCorrente);
        return ResponseEntity.ok().build();
    }
    
    
}
