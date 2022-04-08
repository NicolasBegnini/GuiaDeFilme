package br.senai.sp.FelipeNicolas.guiadefilmes.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	@Column(columnDefinition = "TEXT") //deixa ultrapassar dos 255 caráctere
	private String descricao;
	
	private String duracao;
	
	private String dataLancamento;
	
	private String atores;
	
	private String dubladores;
	
	@ManyToOne
	private TipoFilme genero;

	private String capa;
	
	private String trailer;
	
	private String legendado;
	
	private String dublado;
	
	private int faixaEtaria;
	
	private String idiomas;
}
