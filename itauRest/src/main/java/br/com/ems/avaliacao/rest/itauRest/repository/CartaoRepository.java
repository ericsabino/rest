package br.com.ems.avaliacao.rest.itauRest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ems.avaliacao.rest.itauRest.model.Cartao;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Integer>{
	Cartao findByNumCartao(String numCartao);
}
