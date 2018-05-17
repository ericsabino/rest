package br.com.ems.avaliacao.rest.itauRest.service;

import java.util.List;

import br.com.ems.avaliacao.rest.itauRest.dto.CartaoDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cartao;

public interface CartaoService {
	public Cartao saveCartao(Cartao cartao);
	public Cartao findByCartao(Integer idCartao);
	public Cartao findByNumCartao(String numCartao);
	public CartaoDTO updateCartao(CartaoDTO cartao);
	public List<CartaoDTO> findCartoesAll();
	
}
