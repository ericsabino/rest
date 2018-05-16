package br.com.ems.avaliacao.rest.itauRest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ems.avaliacao.rest.itauRest.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	Cliente findById(int idCliente);       
    Cliente findByCpf(String cpf);
}
