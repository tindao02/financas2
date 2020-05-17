package com.tindao.financas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindao.financas.Repository.UsuarioRepository;
import com.tindao.financas.model.Usuario;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario)
	{
		Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioExistente != null)
		{
			System.out.println("Já existe um cliente cadastrado com este e-mail");
		}
		return usuarioRepository.save(usuario);
	}
	
}
