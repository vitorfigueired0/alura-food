package com.vitor.alura_food_pagamentos.dto;

import com.vitor.alura_food_pagamentos.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagamentoDTO {
  private Long id;
  private BigDecimal valor;
  private String nome;
  private String numero;
  private String expiracao;
  private String codigo;
  private Status status;
  private Long formaDePagamentoId;
  private Long pedidoId;
}
