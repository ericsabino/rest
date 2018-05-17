package br.com.ems.avaliacao.rest.itauRest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ems.avaliacao.rest.exception.ResourceNotFoundException;
import br.com.ems.avaliacao.rest.itauRest.dto.CartaoDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cartao;
import br.com.ems.avaliacao.rest.itauRest.repository.CartaoRepository;
import br.com.ems.avaliacao.rest.itauRest.service.CartaoService;

@Service
public class CartaoServiceImpl implements CartaoService {

	@Autowired
	private CartaoRepository CartaoRepository;

	@Transactional
	public Cartao saveCartao(Cartao Cartao) {
		return CartaoRepository.save(Cartao);
	}

	@Transactional
	public Cartao findByCartao(Integer idCartao) {
		Optional<Cartao> Cartao = CartaoRepository.findById(idCartao);
		return Cartao.get();
	}

	@Transactional
	public CartaoDTO updateCartao(CartaoDTO cartaoDTO) {

		Cartao Cartao = findByNumCartao(cartaoDTO.getNumCartao());
		if (Cartao != null) {
			Cartao.setAtivo(cartaoDTO.getAtivo());
			Cartao CartaoUpdate = CartaoRepository.save(Cartao);
			BeanUtils.copyProperties(CartaoUpdate, cartaoDTO);
			return cartaoDTO;
		} else {
			new ResourceNotFoundException("CARTÃO: [" + cartaoDTO.getNumCartao() + "] NÃO ENCONTRADO !!");
		}
		return null;
	}

	@Transactional
	@Override
	public List<CartaoDTO> findCartoesAll() {

		List<CartaoDTO> list = new ArrayList<>();
		CartaoRepository.findAll().forEach($ -> {
			CartaoDTO CartaoDTO = new CartaoDTO();
			BeanUtils.copyProperties($, CartaoDTO);
			list.add(CartaoDTO);
		});
		return list;
	}

	@Override
	public Cartao findByNumCartao(String numCartao) {
		return CartaoRepository.findByNumCartao(numCartao);
	}



}
