package br.com.ems.avaliacao.rest.itauRest.contrellers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.service.ItauService;

@RestController
@RequestMapping("/api/itau")
public class ItauController {

	@Autowired
	private ItauService itauService;
	
	@GetMapping("/cliente")
	public void controller1() {
		Cliente cliente = new Cliente();
		cliente.setCpf("35518281803");
		cliente.setNome("Eric Meirelles Sabino");
//		itauService.salvarCliente(cliente);
		Cliente findByCpf = itauService.findByCpf(cliente.getCpf());
		System.out.println(findByCpf.getNome());
	}
	
	
	
	
	
	
}
