package br.com.ems.avaliacao.rest.itauRest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger logger = LogManager.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	@Override
	public ClienteDTO saveCliente(Cliente cliente) {
		logger.info("[" + ClienteServiceImpl.class.getName() + "] => INSERINDO CLIENTE NA BASE");
		ClienteDTO clienteDTO = new ClienteDTO();
		Cliente save = clienteRepository.save(cliente);
		BeanUtils.copyProperties(save, clienteDTO);
		return clienteDTO;
	}

	@Transactional
	@Override
	public ClienteDTO findCliente(Integer idCliente) {
		logger.info("[" + ClienteServiceImpl.class.getName() + "] => CONSULTANDO CLIENTE DE ID: " + idCliente);
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
		logger.error("[" + ClienteServiceImpl.class.getName() + "] => CPF: " + cpf + "NÃO ENCONTRADO");
		return null;
	}

	@Transactional
	@Override
	public ClienteDTO updateCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		try {
			ClienteDTO findByCpf = findByCpf(clienteDTO.getCpf());
			if (findByCpf != null) {
				findByCpf.setNome(clienteDTO.getNome());
				BeanUtils.copyProperties(findByCpf, cliente);
				Cliente clienteUpdate = clienteRepository.save(cliente);
				BeanUtils.copyProperties(clienteUpdate, clienteDTO);
				return clienteDTO;
			}
			logger.error("[" + ClienteServiceImpl.class.getName() + "] => CPF: " + clienteDTO.getCpf() + " NÃO EXISTE");
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("CPF: [" + clienteDTO.getCpf() + "] NÃO ENCONTRADO !!");
		}
		return null;
	}

	@Transactional
	@Override
	public List<ClienteDTO> findClientesAll() {
		logger.info("[" + ClienteServiceImpl.class.getName() + "] => LISTANDO TODOS CLIENTES DA BASE");
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
		try {
			ClienteDTO findByCpf = findByCpf(clienteDTO.getCpf());
			if (findByCpf != null) {
				BeanUtils.copyProperties(findByCpf, cliente);
				clienteRepository.delete(cliente);
			}
		} catch (Exception e) {
			logger.error("NÃO FOI POSSÍVEL EXCLUIR O CLIENTE DA BASE");
			throw new ResourceNotFoundException("NÃO FOI POSSÍVEL EXCLUIR O CLIENTE DA BASE");
		}
	}

}
