package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.converter.DozerConverter;
import br.com.banco.data.dto.ContaDto;
import br.com.banco.data.model.Conta;
import br.com.banco.data.validy.ValidyEntityConta;
import br.com.banco.exception.InvalidParamsException;
import br.com.banco.exception.ResourceNotFoundException;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	@Autowired
	private ValidyEntityConta validyParam;
	
	public List<ContaDto> findAll (){
		
		List<ContaDto> contas = DozerConverter.parseList(repository.findAll(), ContaDto.class);
		return contas;
	}
	
	public ContaDto findById(Integer id){
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records matches for this ID!"));
		return DozerConverter.parseObject(entity, ContaDto.class);
	}
	
	public ContaDto create(ContaDto dto) {
		
		try {
			validyParam.entityIsValid(dto);
		} catch (Exception e) {
			throw new InvalidParamsException(e.getMessage());
		}
		
		var entity = repository.save(DozerConverter.parseObject(dto, Conta.class));
		
		
		
		return DozerConverter.parseObject(entity, ContaDto.class);
	}
	
	public void delete (Integer id) {
		var entity = findById(id);
		
		repository.delete(DozerConverter.parseObject(entity, Conta.class));
		
	}
	
	public ContaDto update (Integer id, ContaDto dto) {
		
		try {
			validyParam.entityIsValid(dto);
		} catch (Exception e) {
			throw new InvalidParamsException(e.getMessage());
		}
		
		var entityDto = findById(id);
		
		entityDto.setNome(dto.getNome());
		
		var entity = repository.save(DozerConverter.parseObject(entityDto, Conta.class));
		
		return DozerConverter.parseObject(entity, ContaDto.class);
		
	}

}
