package com.tindao.financas.RepresentationModel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.tindao.financas.enuns.StatusLancamento;
import com.tindao.financas.enuns.TipoLancamento;

import lombok.Data;

@Data
public class LancamentoOutput 
{
	private UsuarioOutput usuario;
	private String descricao;
	private OffsetDateTime data;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private StatusLancamento status;
}
