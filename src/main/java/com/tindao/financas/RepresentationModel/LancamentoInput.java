package com.tindao.financas.RepresentationModel;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tindao.financas.enuns.StatusLancamento;
import com.tindao.financas.enuns.TipoLancamento;

import lombok.Data;

@Data
public class LancamentoInput 
{
	@NotNull
	@Valid
	private UsuarioFk usuario;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusLancamento status;
}
