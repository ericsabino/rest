package br.com.ems.avaliacao.rest.itauRest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ems.avaliacao.rest.itauRest.model.Cartao;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Integer>{
//	Cartao findCartaoByCliente(Cliente cliente);
	Cartao findByNumCartao(String numCartao);
}
