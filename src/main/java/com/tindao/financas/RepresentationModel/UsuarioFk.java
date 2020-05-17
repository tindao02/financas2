package com.tindao.financas.RepresentationModel;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UsuarioFk 
{
	@NotNull
	private Long id;
}
