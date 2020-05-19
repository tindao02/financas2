package com.tindao.financas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tindao.financas.RepresentationModel.LancamentoInput;
import com.tindao.financas.RepresentationModel.LancamentoOutput;
import com.tindao.financas.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController 
{
	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping("/{lancamentoId}")
	public ResponseEntity<LancamentoOutput> buscar(@PathVariable Long lancamentoId)
	{
		return lancamentoService.buscar(lancamentoId);
	}
	
	@GetMapping
	public List<LancamentoOutput> listar()
	{
		return lancamentoService.listar();
	}
	
	@PostMapping
	public LancamentoOutput salvar(@Valid @RequestBody LancamentoInput lancamentoInput)
	{
		return lancamentoService.salvar(lancamentoInput);
	}
	
	@DeleteMapping("/{lancamentoId}")
	public ResponseEntity<Void> delete(@PathVariable Long lancamentoId)
	{
		return lancamentoService.delete(lancamentoId);
	}
}
