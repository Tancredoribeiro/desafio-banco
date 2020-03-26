package com.br.desafio.banco.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaqueDTO {   

    private Long id;
    
    @NotBlank
    private String conta;
    
    @NotBlank
    private String agencia;
    
    @NotNull(message = "O valor do saque e obrigatório.")
    @Positive(message = "O valor do saque não pode ser nanor ou igual zero.")
    private Float valor;
    
    private LocalDateTime data;
}
