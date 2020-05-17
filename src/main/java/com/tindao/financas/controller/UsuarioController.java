package com.tindao.financas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tindao.financas.Repository.UsuarioRepository;
import com.tindao.financas.RepresentationModel.UsuarioInput;
import com.tindao.financas.RepresentationModel.UsuarioOutput;
import com.tindao.financas.model.Usuario;
import com.tindao.financas.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioOutput> listar()
	{
		return toListUsuarioOutput(usuarioRepository.findAll());
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<UsuarioOutput> buscar(@PathVariable Long usuarioId)
	{
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		
		if(usuario.isPresent())
		{
			UsuarioOutput usuarioOutput = toUsuarioOutput(usuario.get());
			return ResponseEntity.ok(usuarioOutput);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioOutput adicionar(@Valid @RequestBody UsuarioInput usuarioInput)
	{
		Usuario usuario = toUsuario(usuarioInput);
		return toUsuarioOutput(usuarioService.salvar(usuario));
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> remover (@PathVariable Long usuarioId)
	{
		if(!usuarioRepository.existsById(usuarioId))
		{
			return ResponseEntity.notFound().build();
		}
		usuarioService.excluir(usuarioId);
		return ResponseEntity.noContent().build();
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
