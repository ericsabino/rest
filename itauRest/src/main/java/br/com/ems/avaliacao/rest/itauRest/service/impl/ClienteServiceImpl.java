package br.com.ems.avaliacao.rest.itauRest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ems.avaliacao.rest.exception.ResourceNotFoundException;
import br.com.ems.avaliacao.rest.itauRest.dto.ClienteDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.repository.ClienteRepository;
import br.com.ems.avaliacao.rest.itauRest.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	@Override
	public ClienteDTO saveCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		Cliente save = clienteRepository.save(cliente);
		BeanUtils.copyProperties(save, clienteDTO);
		return clienteDTO;
	}

	@Transactional
	@Override
	public ClienteDTO findCliente(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		ClienteDTO clienteDTO = new ClienteDTO();
		BeanUtils.copyProperties(cliente.get(), clienteDTO);
		return clienteDTO;
	}

	@Transactional
	@Override
	public ClienteDTO findByCpf(String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		if (cliente != null) {
			ClienteDTO clienteDTO = new ClienteDTO();
			BeanUtils.copyProperties(cliente, clienteDTO);
			return clienteDTO;
		}
		return null;
	}

	@Transactional
	@Override
	public ClienteDTO updateCliente(ClienteDTO clienteDTO) {
		ClienteDTO findByCpf = findByCpf(clienteDTO.getCpf());
		Cliente cliente = new Cliente();
		if (findByCpf != null) {
			findByCpf.setNome(clienteDTO.getNome());
			BeanUtils.copyProperties(findByCpf, cliente);
			Cliente clienteUpdate = clienteRepository.save(cliente);
			BeanUtils.copyProperties(clienteUpdate, clienteDTO);
			return clienteDTO;
		} else {
			new ResourceNotFoundException("CPF: [" + clienteDTO.getCpf() + "] NÃO ENCONTRADO !!");
		}
		return null;
	}

	@Transactional
	@Override
	public List<ClienteDTO> findClientesAll() {

		List<ClienteDTO> list = new ArrayList<>();
		clienteRepository.findAll().forEach($ -> {
			ClienteDTO clienteDTO = new ClienteDTO();
			BeanUtils.copyProperties($, clienteDTO);
			list.add(clienteDTO);
		});
		return list;
	}

	@Transactional
	@Override
	public void deleteCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		ClienteDTO findByCpf = findByCpf(clienteDTO.getCpf());
		if (findByCpf != null) {
			BeanUtils.copyProperties(findByCpf, cliente);
			clienteRepository.delete(cliente);
		}
	}

}
