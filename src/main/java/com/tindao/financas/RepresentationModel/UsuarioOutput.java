package com.tindao.financas.RepresentationModel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


import lombok.Data;

@Data
public class UsuarioOutput 
{
	private String nome;
	private String email;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LancamentoOutput> lancamentos;
}
