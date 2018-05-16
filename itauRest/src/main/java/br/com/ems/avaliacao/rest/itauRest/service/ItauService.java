package br.com.ems.avaliacao.rest.itauRest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.repository.ClienteRepository;

@Service
public class ItauService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente findCliente(Integer idCliente) {
	Optional<Cliente> cliente = clienteRepository.findById(idCliente);
	return cliente.get();	
	}
	
	@Transactional
	public Cliente findByCpf(String cpf) {
		return clienteRepository.findByCpf("35518281803");
	}
	
	
	
}
