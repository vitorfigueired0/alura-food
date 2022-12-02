package com.vitor.alura_food_pagamentos.repository;

import com.vitor.alura_food_pagamentos.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
