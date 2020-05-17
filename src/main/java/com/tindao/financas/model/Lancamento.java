package com.tindao.financas.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tindao.financas.enuns.StatusLancamento;
import com.tindao.financas.enuns.TipoLancamento;

import lombok.Data;

@Data
@Entity
public class Lancamento 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	
	private String descricao;
	private OffsetDateTime data;
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	@Enumerated(EnumType.STRING)
	private StatusLancamento status;
	
	public void mudarTipoParaReceita()
	{
		if(TipoLancamento.RECEITA.equals(getTipo()))
		{
			System.out.println("O Tipo já está como Receita");
		}
		setTipo(TipoLancamento.RECEITA);
	}
	
	public void mudarTipoParaDespesa()
	{
		if(TipoLancamento.DESPESA.equals(getTipo()))
		{
			System.out.println("O Tipo já está como Despesa");
		}
		setTipo(TipoLancamento.DESPESA);
	}
	
	public void mudarStatusParaPendente()
	{
		if(StatusLancamento.PENDENTE.equals(getStatus()))
		{
			System.out.println("O Status já está Pendente");
		}
		setStatus(StatusLancamento.PENDENTE);
	}
	
	public void mudarStatusParaCancelado()
	{
		if(StatusLancamento.CANCELADO.equals(getStatus()))
		{
			System.out.println("O Status já está Cancelado");
		}
		setStatus(StatusLancamento.CANCELADO);
	}
	
	public void mudarStatusParaEfetivado()
	{
		if(StatusLancamento.EFETIVADO.equals(getStatus()))
		{
			System.out.println("O Status já está como Efetivado");
		}
		setStatus(StatusLancamento.EFETIVADO);
	}
	
}
