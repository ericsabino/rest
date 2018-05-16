package br.com.ems.avaliacao.rest.itauRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Score {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Integer id;
	
	@OneToOne
	@Getter @Setter
	private Cliente cliente;
	
	@Getter @Setter
	private Integer pontuacao;
}
