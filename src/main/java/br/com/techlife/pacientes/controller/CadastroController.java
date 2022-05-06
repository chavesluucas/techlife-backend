package br.com.techlife.pacientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techlife.pacientes.data.dto.CadastroDTO;
import br.com.techlife.pacientes.service.CadastroService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cadastro")
public class CadastroController {

	@Autowired
	CadastroService service;

	@GetMapping
	public List<CadastroDTO> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public CadastroDTO getById(@PathVariable("id") Integer id) throws Exception {
		return service.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<CadastroDTO> save(@RequestBody CadastroDTO cadastro) {
		return new ResponseEntity<CadastroDTO>(service.save(cadastro), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) throws Exception{
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
}
