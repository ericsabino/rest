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

@Entity
public class Servicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	@Enumerated(value = EnumType.STRING)
	@Column(length = 15)
	private EnumProduto servicosBanco;
	private Instant data;

	public EnumProduto getServicosBanco() {
		return servicosBanco;
	}

	public void setServicosBanco(EnumProduto servicosBanco) {
		this.servicosBanco = servicosBanco;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

}
