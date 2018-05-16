package br.com.ems.avaliacao.rest.itauRest.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ems.avaliacao.rest.itauRest.utils.EnumProduto;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Servicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(length = 50)
	@Getter @Setter
	private EnumProduto servicosBanco;
	
	@Getter @Setter
	private Instant data;

}
