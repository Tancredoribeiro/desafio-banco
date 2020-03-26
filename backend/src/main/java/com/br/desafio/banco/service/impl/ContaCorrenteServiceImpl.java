package com.br.desafio.banco.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.desafio.banco.domain.ContaCorrente;
import com.br.desafio.banco.dto.ContaCorrenteDTO;
import com.br.desafio.banco.exception.ContaCorrenteNaoEncontradaException;
import com.br.desafio.banco.exception.SaldoNaoEncontradaException;
import com.br.desafio.banco.mapper.ContaCorrenteMapper;
import com.br.desafio.banco.repository.ContaCorrenteRepository;
import com.br.desafio.banco.service.ContaCorrenteService;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    private ContaCorrenteRepository contaCorrenteRepository;

    private ContaCorrenteMapper contaCorrenteMapper;

    @Autowired
    public ContaCorrenteServiceImpl(ContaCorrenteRepository contaCorrenteRepository,
            ContaCorrenteMapper contaCorrenteMapper) {
        super();
        this.contaCorrenteRepository = contaCorrenteRepository;
        this.contaCorrenteMapper = contaCorrenteMapper;
    }

    @Override
    public ContaCorrenteDTO criar(ContaCorrenteDTO dto) {
        ContaCorrente contaCorrente = contaCorrenteMapper.contaCorrenteDTOToContaCorrente(dto);
        return contaCorrenteMapper.contaCorrenteToContaCorrenteDTO(contaCorrenteRepository.save(contaCorrente));
    }

    @Override
    public ContaCorrenteDTO atualizar(ContaCorrenteDTO dto, Long id) {
        Optional<ContaCorrente> optional = contaCorrenteRepository.findById(id);
        ContaCorrente contaCorrente = optional.orElseThrow(() -> new ContaCorrenteNaoEncontradaException(
                String.format("Conta Corrente não encontrado com o id %s.", id)));
        BeanUtils.copyProperties(dto, contaCorrente);

        dto = contaCorrenteMapper.contaCorrenteToContaCorrenteDTO(contaCorrenteRepository.save(contaCorrente));
        return dto;
    }
    @Override
    public ContaCorrente atualizar(ContaCorrente contaCorrente) {  
        return contaCorrenteRepository.save(contaCorrente);
    }

    @Override
    public ContaCorrenteDTO buscarPorId(@NotNull Long id) {
        Optional<ContaCorrente> optional = contaCorrenteRepository.findById(id);
        ContaCorrente contaCorrente = optional.orElseThrow(() -> new ContaCorrenteNaoEncontradaException(
                String.format("Conta Corrente não encontrado com o id %s.", id)));

        ContaCorrenteDTO dto = contaCorrenteMapper.contaCorrenteToContaCorrenteDTO(contaCorrente);
        return dto;
    }

    @Override
    public ContaCorrente buscarPorAgenciaECodigo(String agencia, String codigo) {
        Optional<ContaCorrente> optional = contaCorrenteRepository.findByAgenciaAndCodigo(agencia, codigo);
        ContaCorrente contaCorrente = optional.orElseThrow(() -> new ContaCorrenteNaoEncontradaException(String.format(
                "Conta Corrente não encontrado com a Agencia (%s) e o Código (%s) informados.", agencia, codigo)));

        return contaCorrente;
    }

    @Override
    public List<ContaCorrenteDTO> buscarTodas() {
        List<ContaCorrente> contaCorrentes = contaCorrenteRepository.findAll();
        return contaCorrentes.stream().map(p -> {
            return contaCorrenteMapper.contaCorrenteToContaCorrenteDTO(p);
        }).collect(Collectors.toList());
    }

    @Override
    public void excluir(@NotNull Long id) {
        Optional<ContaCorrente> optional = contaCorrenteRepository.findById(id);
        ContaCorrente contaCorrente = optional.orElseThrow(() -> new ContaCorrenteNaoEncontradaException(
                String.format("Conta Corrente não encontrado com o id %s.", id)));
        contaCorrenteRepository.delete(contaCorrente);

    }


    @Override
    public Float buscarSaldoPorAgenciaECodigo( String agencia,  String codigo) {
        Optional<Float> optional = contaCorrenteRepository.buscarSaldoPorAgenciaECodigo(agencia, codigo);
        Float saldo = optional.orElseThrow(() -> new SaldoNaoEncontradaException(
                String.format("Saldo não encontrado para a conta de codigo: %s.", codigo)));
        return saldo;
    }

}
