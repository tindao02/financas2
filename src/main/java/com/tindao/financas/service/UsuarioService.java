package com.tindao.financas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tindao.financas.Repository.UsuarioRepository;
import com.tindao.financas.RepresentationModel.UsuarioInput;
import com.tindao.financas.RepresentationModel.UsuarioOutput;
import com.tindao.financas.model.Usuario;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<UsuarioOutput> listar()
	{
		return toListUsuarioOutput(usuarioRepository.findAll());
	}
	
	public ResponseEntity<UsuarioOutput> buscar(Long usuarioId)
	{
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		
		if(usuario.isPresent())
		{
			return ResponseEntity.ok(toUsuarioOutput(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public UsuarioOutput salvar(UsuarioInput usuarioInput)
	{
		Usuario usuario = toUsuario(usuarioInput);
		
		Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioExistente != null)
		{
			System.out.println("Já existe um cliente cadastrado com este e-mail");
		}
		return toUsuarioOutput(usuarioRepository.save(usuario));
	}
	public ResponseEntity<Void> delete(Long usuarioId)
	{
		if(!usuarioExiste(usuarioId)) 
		{
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(usuarioId);
		
		return ResponseEntity.noContent().build();
	}
	
	private boolean usuarioExiste(Long usuarioId)
	{
		return usuarioRepository.existsById(usuarioId);
	}
	
	//****************************
	private UsuarioOutput toUsuarioOutput(Usuario usuario)
	{
		return modelMapper.map(usuario, UsuarioOutput.class);
	}
	
	private List<UsuarioOutput> toListUsuarioOutput(List<Usuario> usuarios)
	{
		return usuarios.stream()
				.map(usuario -> toUsuarioOutput(usuario))
				.collect(Collectors.toList());
	}
	
	private Usuario toUsuario(UsuarioInput usuarioInput)
	{
		return modelMapper.map(usuarioInput, Usuario.class);
	}
	
}
