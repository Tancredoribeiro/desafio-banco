package com.br.desafio.banco.repository;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.desafio.banco.domain.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    Optional<ContaCorrente> findByAgenciaAndCodigo(String agencia, String codigo);

    @Query(value = "select saldo from ContaCorrente where agencia = :agencia and codigo = :codigo")
    Optional<Float> buscarSaldoPorAgenciaECodigo(@Param("agencia") String agencia, @Param("codigo") String codigo);
}
