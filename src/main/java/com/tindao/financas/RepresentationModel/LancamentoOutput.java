package com.tindao.financas.RepresentationModel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tindao.financas.enuns.StatusLancamento;
import com.tindao.financas.enuns.TipoLancamento;

import lombok.Data;

@Data
public class LancamentoOutput 
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private UsuarioOutput usuario;
	
	private String descricao;
	private OffsetDateTime data;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private StatusLancamento status;
}
