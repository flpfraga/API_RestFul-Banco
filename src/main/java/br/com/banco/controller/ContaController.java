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

import br.com.banco.data.dto.ContaDto;
import br.com.banco.service.ContaService;

@RestController
@RequestMapping("/api/conta/v1")
public class ContaController {
	
	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<ContaDto>> findAll(){
		
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ContaDto> findAll(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<ContaDto> create(@RequestParam ContaDto contaDto){
		
		return ResponseEntity.ok(service.create(contaDto));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok("");
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,
			@RequestParam ContaDto contaDto
			){
		
		return ResponseEntity.ok(service.update(id, contaDto));
		
	}
	
}
