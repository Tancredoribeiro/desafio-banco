package com.br.desafio.banco.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta_corrente")
public class ContaCorrente implements Serializable {

      private static final long serialVersionUID = 1L;
      
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      
      @Column(name = "codigo")
      private String codigo;
      
      @Column(name = "agencia")
      private String agencia;
      
      @Column(name = "cpf_titular")
      private String cpfTitular;
      
      @Column(name = "nome_titular")
      private String nomeTitular;
      
      @Column(name = "saldo")
      private Float saldo;
      
      @OneToMany(fetch = FetchType.LAZY, mappedBy = "contaCorrente", cascade = CascadeType.ALL, orphanRemoval = true)
      private Set<Saque> saques;
      
      @OneToMany(fetch = FetchType.LAZY, mappedBy = "contaCorrente", cascade = CascadeType.ALL, orphanRemoval = true)
      private Set<Deposito>  depositos;

}
