package com.br.desafio.banco.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrenteDTO {

    
    private Long id;
    
    @NotBlank
    private String codigo;
    
    @NotBlank
    private String agencia;
    
    @NotBlank
    private String cpfTitular;
    
    @NotBlank
    private String nomeTitular;
    
    @NotNull
    private Float saldo;

}
