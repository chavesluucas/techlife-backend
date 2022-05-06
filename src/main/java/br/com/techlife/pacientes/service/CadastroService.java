package br.com.techlife.pacientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.techlife.pacientes.data.dto.CadastroDTO;
import br.com.techlife.pacientes.data.entity.Cadastro;
import br.com.techlife.pacientes.repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	CadastroRepository repository;

	
	public List<CadastroDTO> getAll(){
		List<Cadastro> cadastros = repository.findAll();
		List<CadastroDTO> listDTOs = new ArrayList<>();
		
		for(Cadastro cadastro : cadastros) {
			listDTOs.add(cadastro.getDTO()); 
		}
		
		return listDTOs;
	}
	
	
	public CadastroDTO getById(Integer id) throws Exception {
		Cadastro cadastro = repository.findById(id)
									  .orElseThrow(
											  ()-> new Exception("Cadastro não localizado"));
		return cadastro.getDTO();
	}
	
	
	public CadastroDTO save(CadastroDTO dto) {
		Cadastro cadastro = repository.save(dto.convertToEntity());
		return cadastro.getDTO();
	}
	
	
	public Boolean delete(Integer idCadastro) throws Exception {
		Cadastro delCad = repository.findById(idCadastro)
									.orElseThrow(
												()-> new Exception("Cadastro não localizado"));
		repository.delete(delCad);
		return true;
	}
}
