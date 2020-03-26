package com.br.desafio.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.desafio.banco.domain.Deposito;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Long> {

}
