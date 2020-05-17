package com.tindao.financas.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.tindao.financas.RepresentationModel.UsuarioInput;
import com.tindao.financas.RepresentationModel.UsuarioOutput;
import com.tindao.financas.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController 
{	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioOutput> listar()
	{
		return usuarioService.listar();
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<UsuarioOutput> buscar(@PathVariable Long usuarioId)
	{
		return usuarioService.buscar(usuarioId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioOutput salvar(@Valid @RequestBody UsuarioInput usuarioInput)
	{
		return usuarioService.salvar(usuarioInput);
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> delete (@PathVariable Long usuarioId)
	{
		return usuarioService.delete(usuarioId);
	}
	
}
