package com.giRocha.prjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long funcodigo;
	

	private String funnome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;
	

	private float funsalario;

	public long getFuncodigo() {
		return funcodigo;
	}

	public void setFuncodigo(long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getFunnome() {
		return funnome;
	}

	public void setFunnome(String funnome) {
		this.funnome = funnome;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public float getFunsalario() {
		return funsalario;
	}

	public void setFunsalario(float funsalario) {
		this.funsalario = funsalario;
	}
	
	@ManyToOne
	private Departamento departamento;

	//inserir os metodos get e o set
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
