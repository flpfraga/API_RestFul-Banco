package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.data.dto.TransferenciaDto;
import br.com.banco.data.model.Transferencia;
import br.com.banco.data.query.QueryExampleParamsTransferencia;
import br.com.banco.interfaces.query.QueryExampleParams;
import br.com.banco.service.TransferenciaService;


@RestController
@RequestMapping("/api/transf/v1")
public class TransferenciaController {

	@Autowired
	private TransferenciaService service;
	
	
	@GetMapping
	public ResponseEntity<List<TransferenciaDto>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TransferenciaDto> findById(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<TransferenciaDto> create(@RequestParam TransferenciaDto dto){
		return ResponseEntity.ok(service.create(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok("");
	}
	@PutMapping("/{id}")
	public ResponseEntity<TransferenciaDto> create(@PathVariable Integer id,
			@RequestParam TransferenciaDto dto
			){
		return ResponseEntity.ok(service.update(id, dto));
	}
		
	@GetMapping("/conta/{contaId}")
	public ResponseEntity<?> findAll(
			@PathVariable Integer contaId,
			@RequestParam(value = "date_begin", required = false)String dateBegin,
			@RequestParam(value = "date_end", required = false)String dateEnd,
			@RequestParam(value = "user", required = false)String user
			){
		
		QueryExampleParams<Transferencia> queryParams = new QueryExampleParamsTransferencia();
		if (user== null &&  dateBegin == null) {
			return ResponseEntity.ok(service.findTransferencias (contaId, queryParams));
		}
		if (user == null) {
			queryParams.setDataInicio(dateBegin);
			queryParams.setDataFim(dateEnd);
			return ResponseEntity.ok(service.findByPeriod (contaId, queryParams));
		}
		if (dateBegin == null) {
			queryParams.setOperador(user);
			return ResponseEntity.ok(service.findTransferencias(contaId, queryParams));
		}
		
		queryParams.setDataInicio(dateBegin);
		queryParams.setDataFim(dateEnd);
		queryParams.setOperador(user);
		return ResponseEntity.ok(service.findByPeriodWithOperator(contaId, queryParams));
	}

}
