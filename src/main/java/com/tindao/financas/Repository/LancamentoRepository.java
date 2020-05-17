package com.tindao.financas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tindao.financas.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>
{

}
