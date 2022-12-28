package br.com.banco.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.converter.DateConverter;
import br.com.banco.converter.DozerConverter;
import br.com.banco.data.dto.ContaDto;
import br.com.banco.data.dto.TransferenciaDto;
import br.com.banco.data.model.Conta;
import br.com.banco.data.model.Transferencia;
import br.com.banco.data.validy.ValidyParamsTransferencia;
import br.com.banco.exception.InvalidParamsException;
import br.com.banco.exception.ResourceNotFoundException;
import br.com.banco.interfaces.query.QueryExampleParams;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository repository;

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired 
	private ValidyParamsTransferencia validyParam;

	public List<TransferenciaDto> findAll() {

		List<TransferenciaDto> transferencias = DozerConverter.parseList(repository.findAll(), TransferenciaDto.class);
		return transferencias;
	}

	public TransferenciaDto findById(Integer id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records matches for this ID!"));
		return DozerConverter.parseObject(entity, TransferenciaDto.class);
	}

	public TransferenciaDto create(TransferenciaDto dto) {

		var entity = repository.save(DozerConverter.parseObject(dto, Transferencia.class));
		
		try {
			validyParam.entityIsValid(dto);
		} catch (Exception e) {
			throw new InvalidParamsException(e.getMessage());
		}

		return DozerConverter.parseObject(entity, TransferenciaDto.class);
	}

	public void delete(Integer id) {
		var entity = findById(id);

		repository.delete(DozerConverter.parseObject(entity, Transferencia.class));

	}

	public TransferenciaDto update(Integer id, TransferenciaDto dto) {

		var entityDto = findById(id);

		var contaDto = findContaById(dto.getConta().getId_conta());
		
		try {
			validyParam.entityIsValid(dto);
		} catch (Exception e) {
			throw new InvalidParamsException(e.getMessage());
		}
		entityDto.setConta(DozerConverter.parseObject(contaDto, Conta.class));
		entityDto.setData(dto.getData());
		entityDto.setOperador(dto.getOperador());
		entityDto.setTipo(dto.getTipo());
		entityDto.setValor(dto.getValor());

		var entity = repository.save(DozerConverter.parseObject(entityDto, Transferencia.class));

		return DozerConverter.parseObject(entity, TransferenciaDto.class);

	}

	public List<Transferencia> findTransferencias(Integer contaId, QueryExampleParams<Transferencia> queryParams) {
		
		var entityContaDto = findContaById(contaId);
		Transferencia transferencia = new Transferencia();
		transferencia.setConta(DozerConverter.parseObject(entityContaDto, Conta.class));
		return repository.findAll(queryParams.getExample(transferencia));
	}

	public List<Transferencia> findByPeriod(Integer contaId, QueryExampleParams<Transferencia> queryParams) {
		try {
			validyParam.paramsIsValid(queryParams);
		} catch (Exception e) {
			throw new InvalidParamsException(e.getMessage());
		}
		
		var entityContaDto = findContaById(contaId);
		try {
			Date inicio = DateConverter.convertString(queryParams.getDataInicio());
			Date fim = DateConverter.convertString(queryParams.getDataFim());
			return repository.findByPeriod(DozerConverter.parseObject(entityContaDto, Conta.class), inicio, fim);
		} catch (ParseException e) {
			throw new br.com.banco.exception.ParseException(
					"Data param values not acceptable. Use the pattern: dd/mm/yyyy");
		}
	}

	public List<Transferencia> findByPeriodWithOperator(Integer contaId, QueryExampleParams<Transferencia> queryParams) {
		try {
			validyParam.paramsIsValid(queryParams);
		} catch (Exception e) {
			throw new InvalidParamsException(e.getMessage());
		}
		
		var entityContaDto = findContaById(contaId);

		try {
			Date inicio = DateConverter.convertString(queryParams.getDataInicio());
			Date fim = DateConverter.convertString(queryParams.getDataFim());
			return repository.findByPeriod(DozerConverter.parseObject(entityContaDto, Conta.class), inicio, fim,
					queryParams.getOperador());
		} catch (ParseException e) {
			throw new br.com.banco.exception.ParseException(
					"Data param values not acceptable. Use the pattern: dd/mm/yyyy");
		}
	}

	public ContaDto findContaById(Integer conta_id) {

		var entity = contaRepository.findById(conta_id)
				.orElseThrow(() -> new ResourceNotFoundException("No records matches for this ID!"));

		return DozerConverter.parseObject(entity, ContaDto.class);
	}

}
