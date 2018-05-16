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

import br.com.ems.avaliacao.rest.itauRest.utils.EnumTipoCartao;


@Entity
public class Cartao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	@Enumerated(value = EnumType.STRING)
	@Column(length=15)
	private EnumTipoCartao tipocartao;
	@Column(length=16)
	private String numCartao;
	private Instant dataAdesao;
	private Boolean ativo;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public EnumTipoCartao getTipocartao() {
		return tipocartao;
	}
	public void setTipocartao(EnumTipoCartao tipocartao) {
		this.tipocartao = tipocartao;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public Instant getDataAdesao() {
		return dataAdesao;
	}
	public void setDataAdesao(Instant dataAdesao) {
		this.dataAdesao = dataAdesao;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Integer getId() {
		return id;
	}
	
}
