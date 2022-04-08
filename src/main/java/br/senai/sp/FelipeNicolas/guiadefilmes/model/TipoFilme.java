package br.senai.sp.FelipeNicolas.guiadefilmes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class TipoFilme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String genero;
	
	@NotEmpty
	private String descricao;
}
