package br.com.ems.avaliacao.rest.itauRest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ems.avaliacao.rest.itauRest.dto.ClienteDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.repository.ClienteRepository;
import br.com.ems.avaliacao.rest.itauRest.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public Cliente findCliente(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		return cliente.get();
	}

	@Transactional
	public Cliente findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	@Transactional
	public void updateCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Transactional
	public List<ClienteDTO> findClientesAll() {

		List<ClienteDTO> list = new ArrayList<>();
		clienteRepository.findAll().forEach($ -> {
			ClienteDTO clienteDTO = new ClienteDTO();
			BeanUtils.copyProperties($, clienteDTO);
			list.add(clienteDTO);
		});
		return list;
	}

}
