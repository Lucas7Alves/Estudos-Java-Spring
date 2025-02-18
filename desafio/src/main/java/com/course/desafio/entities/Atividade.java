package com.course.desafio.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String descricao;
	private Double preco;
	
	@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();
		
	@ManyToMany
	@JoinTable(name = "tb_atividade_participante",
			joinColumns = @JoinColumn(name = "atividade_id"),
			inverseJoinColumns = @JoinColumn(name = "participante_id"))
	private Set<Participante> participantes = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;	
	
	
	
	//contructors and Getter/Setter
	public Atividade(String name, String descricao, Double preco) {
		this.nome = name;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Bloco> getBlocos() {
		return blocos;
	}
	
	public Set<Participante> getParticipante() {
		return participantes;
	}
}
