package br.com.ems.avaliacao.rest.itauRest.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoCartao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idCartao")
	private Cartao cartao;
	@Column(length=80)
	private String descricao;
	private Instant dataOcorrencia;

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Instant dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public Integer getId() {
		return id;
	}
}
