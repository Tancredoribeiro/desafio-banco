package com.br.desafio.banco.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deposito")
public class Deposito implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cpf_depositante")
    private String cpfDepositante;
    
    @Column(name = "nome_depositante")
    private String nomeDepositante;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_corrente_id")
    private ContaCorrente contaCorrente;
    
    private Float valor;
    
    private LocalDateTime data;

}
