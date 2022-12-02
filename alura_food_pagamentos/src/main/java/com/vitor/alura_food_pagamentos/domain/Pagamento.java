package com.vitor.alura_food_pagamentos.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Pagamentos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Pagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Positive
  private BigDecimal valor;

  @NotBlank
  @Size(max=100)
  private String nome;

  @NotBlank
  @Size(max=19)
  private String numero;

  @NotBlank
  @Size(max=7)
  private String expiracao;

  @NotBlank
  @Size(min=3, max=3)
  private String codigo;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Status status;

  @NotNull
  private Long pedidoId;

  @NotNull
  private Long formaDePagamentoId;
}
