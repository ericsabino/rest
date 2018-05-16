package br.com.ems.avaliacao.rest.itauRest.service;

import java.util.List;

import br.com.ems.avaliacao.rest.itauRest.dto.ClienteDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;

public interface ClienteService {
	public Cliente saveCliente(Cliente cliente);
	public Cliente findCliente(Integer idCliente);
	public Cliente findByCpf(String cpf);
	public void updateCliente(Cliente cliente);
	public List<ClienteDTO> findClientesAll();
	
}
