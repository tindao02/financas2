package com.tindao.financas.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	
	//@OneToMany(mappedBy = "usuario", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	//private List<Lancamento> lancamentos = new ArrayList<>();
}
