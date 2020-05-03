package br.com.alexandre.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String descricao;
	
	@Column(name = "valor_unitario")
	private Double valorUnitario;
	
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;
	
	private Boolean status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Produto() {
		this.dataCriacao = LocalDate.now();
	}

	public Produto(Long codigo, String descricao, Double valorUnitario, Boolean status,
			Usuario usuario) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.dataCriacao = LocalDate.now();
		this.status = status;
		this.usuario = usuario;
	}
	
	

}
