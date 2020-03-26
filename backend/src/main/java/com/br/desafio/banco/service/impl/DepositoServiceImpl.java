package com.br.desafio.banco.service.impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.desafio.banco.domain.ContaCorrente;
import com.br.desafio.banco.domain.Deposito;
import com.br.desafio.banco.dto.DepositoDTO;
import com.br.desafio.banco.mapper.DepositoMapper;
import com.br.desafio.banco.repository.DepositoRepository;
import com.br.desafio.banco.service.ContaCorrenteService;
import com.br.desafio.banco.service.DepositoService;

@Service
public class DepositoServiceImpl implements DepositoService {

    private DepositoRepository depositoRepository;
    
    private ContaCorrenteService contaCorrenteService;
    
    private DepositoMapper depositoMapper;

    @Autowired
    public DepositoServiceImpl(DepositoRepository depositoRepository, ContaCorrenteService contaCorrenteService,
            DepositoMapper depositoMapper) {
        super();
        this.depositoRepository = depositoRepository;
        this.contaCorrenteService = contaCorrenteService;
        this.depositoMapper = depositoMapper;
    }



    @Transactional
    @Override
    public ResponseEntity<?> depositar(DepositoDTO dto) {
        ContaCorrente contaCorrente = contaCorrenteService.buscarPorAgenciaECodigo(dto.getAgencia(), dto.getConta());
        Deposito deposito = depositoMapper.depositoDTOToDeposito(dto);
        deposito.setContaCorrente(contaCorrente);
        deposito.setData(LocalDateTime.now());
        depositoRepository.save(deposito);
        
        Float saldo = contaCorrente.getSaldo();
        Float novoSaldo = saldo + dto.getValor();
        contaCorrente.setSaldo(novoSaldo);
        contaCorrenteService.atualizar(contaCorrente);
        
        return ResponseEntity.ok().build();
    }
    
    
}
