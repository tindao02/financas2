package com.tindao.financas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tindao.financas.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>
{

}
