package br.com.ems.avaliacao.rest.itauRest.service;

import java.util.List;

import br.com.ems.avaliacao.rest.itauRest.dto.ClienteDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;

public interface ClienteService {
	public ClienteDTO saveCliente(Cliente cliente);
	public ClienteDTO findCliente(Integer idCliente);
	public ClienteDTO findByCpf(String cpf);
	public ClienteDTO updateCliente(ClienteDTO clienteDTO);
	public List<ClienteDTO> findClientesAll();
	public void deleteCliente(ClienteDTO clienteDTO);
	
}
