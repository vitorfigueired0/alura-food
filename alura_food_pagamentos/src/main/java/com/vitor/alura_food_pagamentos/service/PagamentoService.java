package com.vitor.alura_food_pagamentos.service;

import com.vitor.alura_food_pagamentos.domain.Pagamento;
import com.vitor.alura_food_pagamentos.domain.Status;
import com.vitor.alura_food_pagamentos.repository.PagamentoRepository;
import com.vitor.alura_food_pagamentos.dto.PagamentoDTO;
import com.vitor.alura_food_pagamentos.dto.PagamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

  @Autowired
  private PagamentoRepository pagamentoRepository;

  @Autowired
  private PagamentoMapper pagamentoMapper;

  public Page<PagamentoDTO> getAll(Pageable pag){
    List<Pagamento> pagamentos = pagamentoRepository.findAll();
    List<PagamentoDTO> pagamentoDTOList = pagamentos.stream().map(pagamento ->
      pagamentoMapper.mapToDto(pagamento)).collect(Collectors.toList());

    Page<PagamentoDTO> page = new PageImpl<>(pagamentoDTOList, pag,10L);
    return page;
  }

  public PagamentoDTO getById(Long id){
    Pagamento pagamento = pagamentoRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return pagamentoMapper.mapToDto(pagamento);
  }

  public PagamentoDTO create(PagamentoDTO pag){
    Pagamento pagamento = pagamentoMapper.mapToDomain(pag);
    pagamento = pagamentoRepository.save(pagamento.withStatus(Status.CRIADO));

    return pagamentoMapper.mapToDto(pagamento);
  }

  public PagamentoDTO update(PagamentoDTO pag){

    Pagamento pagamento = pagamentoMapper.mapToDomain(pag);
    return pagamentoMapper.mapToDto(pagamentoRepository.save(pagamento));
  }

  public void delete(Long id){
    pagamentoRepository.deleteById(id);
  }

}
