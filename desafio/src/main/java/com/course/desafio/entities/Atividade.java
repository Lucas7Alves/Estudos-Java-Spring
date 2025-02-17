package com.course.desafio.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String descricao;
	private Double preco;
	
	@OneToMany(mappedBy = "atividade	")
	private List<Bloco> blocos = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;	
	

	
	
	
	//contructors and Getter/Setter
	public Atividade(String name, String descricao, Double preco) {
		super();
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
