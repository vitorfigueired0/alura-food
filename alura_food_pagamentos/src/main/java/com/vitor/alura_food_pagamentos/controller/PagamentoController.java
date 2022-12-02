package com.vitor.alura_food_pagamentos.controller;

import com.vitor.alura_food_pagamentos.dto.PagamentoDTO;
import com.vitor.alura_food_pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

  @Autowired
  private PagamentoService pagamentoService;

  @PostMapping
  public ResponseEntity<PagamentoDTO> create(@RequestBody PagamentoDTO dto){
    return new ResponseEntity<>(pagamentoService.create(dto), HttpStatus.CREATED);
  }

  @GetMapping
  public Page<PagamentoDTO> getAll(@PageableDefault(size = 10)Pageable pageable){
    return pagamentoService.getAll(pageable);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PagamentoDTO> getBYId(@PathVariable @NotNull Long id){
    return new ResponseEntity<>(pagamentoService.getById(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<PagamentoDTO> update(@RequestBody PagamentoDTO pagamentoDTO){
    return new ResponseEntity<>(pagamentoService.update(pagamentoDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    pagamentoService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
