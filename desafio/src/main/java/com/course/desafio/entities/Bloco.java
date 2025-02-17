package com.course.desafio.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bloco")
public class Bloco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Instant inicio;
	private Instant fim;
	
	@ManyToOne
	@JoinColumn(name = "id_atividade")
	private Atividade atividade;
	
	
	
	public Bloco() {
	}
	
	
	public Bloco(Instant inicio, Instant fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}
	public Instant getInicio() {
		return inicio;
	}
	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}
	public Instant getFim() {
		return fim;
	}
	public void setFim(Instant fim) {
		this.fim = fim;
	}
	
	
}
