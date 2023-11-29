package com.giRocha.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giRocha.prjEmpresa.entities.Departamento;
import com.giRocha.prjEmpresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Departamentos", description = "API REST DE GERENCIAMENTO DE DEPARTAMENTOS")
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	private final DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{depcodigo}")
	@Operation(summary = "Localiza usuário por ID")
	public ResponseEntity<Departamento> findUsuariobyId(@PathVariable Long depcodigo) {
		Departamento departamento = departamentoService.findDepartamentoById(depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	@Operation(summary = "Apresenta todos os usuários")
	public ResponseEntity<List<Departamento>> findAllDepartamentocontrol() {
		List<Departamento> departamentos = departamentoService.findAllDepartamento();
		return ResponseEntity.ok(departamentos);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra um usuário")
	public ResponseEntity<Departamento> insertDepartamentoControl(@RequestBody @Valid Departamento departamento) {
		Departamento novoDepartamento = departamentoService.insertDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}
	
	@PutMapping("/depcodigo")
	@Operation(summary = "Altera um usuário")
	public ResponseEntity<Departamento> updateDeparatmentoControl(@PathVariable Long depcodigo, @RequestBody @Valid Departamento departamento) {
		Departamento mudaDepartamento = departamentoService.updateDepartamento(depcodigo, departamento);
		if (mudaDepartamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/depcodigo")
	@Operation(summary = "Exclui um usuário")
	public ResponseEntity<String> deleteDepartamentoControl(@PathVariable Long depcodigo) {
		boolean remover = departamentoService.deleteDepartamento(depcodigo);
		if (remover) {
			return ResponseEntity.ok().body("Departamento excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
