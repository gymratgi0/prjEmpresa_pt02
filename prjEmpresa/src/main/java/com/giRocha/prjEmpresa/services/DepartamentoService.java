package com.giRocha.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giRocha.prjEmpresa.entities.Departamento;
import com.giRocha.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	// preparando as buscas por id
	public Departamento findDepartamentoById(Long depcodigo) {
		Optional<Departamento> Departamento = departamentoRepository.findById(depcodigo);
		return Departamento.orElse(null);
	}
	
	// preparando a busca geral
	public List<Departamento> findAllDepartamento() {
		return departamentoRepository.findAll();
	}

	// salvando o Jogo
	public Departamento insertDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	// fazendo o update do jogo com o optional
	public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}
	
	// deletando o update do usuario com o optional
	public boolean deleteDepartamento(Long depcodigo) {
		Optional<Departamento> departamentoExistente = departamentoRepository.findById(depcodigo);
		if (departamentoExistente.isPresent()) {
			departamentoRepository.deleteById(depcodigo);
			return true;
		} else {
			return false;
		}
	}

}
