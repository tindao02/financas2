package com.tindao.financas.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tindao.financas.Repository.LancamentoRepository;
import com.tindao.financas.Repository.UsuarioRepository;
import com.tindao.financas.RepresentationModel.LancamentoInput;
import com.tindao.financas.RepresentationModel.LancamentoOutput;
import com.tindao.financas.model.Lancamento;
import com.tindao.financas.model.Usuario;

@Service
public class LancamentoService 
{
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<LancamentoOutput> buscar(Long usuarioId)
	{
		Optional<Lancamento> lancamento = lancamentoRepository.findById(usuarioId);
		
		if(lancamento.isPresent())
		{
			return ResponseEntity.ok(toLancamentoOutput(lancamentoRepository.findById(usuarioId).get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	public List<LancamentoOutput> listar()
	{
		return toListLancamentoOutput(lancamentoRepository.findAll());
	}
	
	public LancamentoOutput salvar(LancamentoInput lancamentoInput)
	{
		Optional<Usuario> usuario = usuarioRepository.findById(lancamentoInput.getUsuario().getId());
		
		if(usuario.isPresent())
		{
			Lancamento lancamento = toLancamento(lancamentoInput);
			lancamento.setUsuario(usuario.get());
			lancamento.setData(OffsetDateTime.now());
			
			lancamentoRepository.save(lancamento);
			
			return toLancamentoOutput(lancamento);
		}
		System.out.println("Usuário não existe.");
		return null;
	}
	
	public ResponseEntity<Void> delete(Long lancamentoId)
	{
		if(!lancamentoExite(lancamentoId)) 
		{
			return ResponseEntity.notFound().build();
		}
		lancamentoRepository.deleteById(lancamentoId);
		
		return ResponseEntity.noContent().build();
	}
	
	private boolean lancamentoExite(Long lancamentoId)
	{
		return lancamentoRepository.existsById(lancamentoId);
	}
	
	//==========================
	private LancamentoOutput toLancamentoOutput(Lancamento lancamento)
	{
		return modelMapper.map(lancamento, LancamentoOutput.class);
	}
	
	private List<LancamentoOutput> toListLancamentoOutput(List<Lancamento> lancamentos)
	{
		return lancamentos.stream().map(lancamento -> toLancamentoOutput(lancamento)).collect(Collectors.toList());
	}
	
	private Lancamento toLancamento (LancamentoInput lancamentoInput)
	{
		return modelMapper.map(lancamentoInput, Lancamento.class);
	}
}
