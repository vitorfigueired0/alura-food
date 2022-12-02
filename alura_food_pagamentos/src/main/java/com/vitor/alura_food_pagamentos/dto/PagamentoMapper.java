package com.vitor.alura_food_pagamentos.dto;

import com.vitor.alura_food_pagamentos.domain.Pagamento;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

  public PagamentoDTO mapToDto(Pagamento pagamento){

    return PagamentoDTO.builder()
      .id(pagamento.getId())
      .valor(pagamento.getValor())
      .nome(pagamento.getNome())
      .numero(pagamento.getNumero())
      .expiracao(pagamento.getExpiracao())
      .codigo(pagamento.getCodigo())
      .status(pagamento.getStatus())
      .formaDePagamentoId(pagamento.getFormaDePagamentoId())
      .pedidoId(pagamento.getPedidoId())
      .build();
  }

   public Pagamento mapToDomain(PagamentoDTO pagamentoDTO){

    return Pagamento.builder()
       .id(pagamentoDTO.getId())
       .valor(pagamentoDTO.getValor())
       .nome(pagamentoDTO.getNome())
       .numero(pagamentoDTO.getNumero())
       .expiracao(pagamentoDTO.getExpiracao())
       .codigo(pagamentoDTO.getCodigo())
       .status(pagamentoDTO.getStatus())
       .formaDePagamentoId(pagamentoDTO.getFormaDePagamentoId())
       .pedidoId(pagamentoDTO.getPedidoId())
       .build();
  }


}
