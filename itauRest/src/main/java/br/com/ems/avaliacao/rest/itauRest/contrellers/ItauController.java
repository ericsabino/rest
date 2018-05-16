package br.com.ems.avaliacao.rest.itauRest.contrellers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ems.avaliacao.rest.itauRest.model.Cartao;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.service.ItauService;
import br.com.ems.avaliacao.rest.itauRest.utils.EnumTipoCartao;

@RestController
@RequestMapping("/api/itau")
public class ItauController {

	@Autowired
	private ItauService itauService;
	
	@GetMapping("/cliente")
	public void controller1() {
		Cliente cliente = new Cliente();
		cliente.setCpf("99999999999");
//		cliente.setNome("Ingrid Nogueira Rocha");
		cliente.setDataCadastro(Instant.now());
		cliente.setSexo('M');
		cliente.setIdade(28);
//		
//		List<Cartao> list = new ArrayList<>();
//		
//		Cartao cartao = new Cartao();
//		cartao.setAtivo(true);
//		cartao.setDataAdesao(Instant.now());
//		cartao.setNumCartao("5153545640408888");
//		cartao.setTipocartao(EnumTipoCartao.CREDITO);
//		
//		cliente.setCartoes(Arrays.asList(cartao));
//		
//		itauService.saveCliente(cliente);
		
		Cliente findByCpf = itauService.findByCpf(cliente.getCpf());
		
		itauService.updateCliente(cliente);
		System.out.println(findByCpf.getNome());
	}
	
	
	
	
	
	
}
