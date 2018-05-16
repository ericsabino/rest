package br.com.ems.avaliacao.rest.itauRest.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ems.avaliacao.rest.itauRest.dto.ClienteDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.service.ClienteService;

@RestController
@RequestMapping("/api/itau")
public class ItauController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ClienteDTO>> getClientes() {
		List<ClienteDTO> list = clienteService.findClientesAll();
		return new ResponseEntity<List<ClienteDTO>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		Cliente saveCliente = clienteService.saveCliente(cliente);
		return new ResponseEntity<Cliente>(saveCliente, HttpStatus.OK);
	}
	
/*	@RequestMapping(value = "update/{idCliente}", method = { RequestMethod.PUT, RequestMethod.PATCH},
		    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		    public ResponseEntity<Cliente> updateSurvivor(
		            @PathVariable("idCliente") Integer idCliente,
		            @RequestParam("nome") String nome) {

		        ClienteDTO survivorDTO = new ClienteDTO(survivorId,
		                            new BigInteger(latitude),
		                            new BigInteger(longitude)
		                            );
		         survivorService.updateLocation(survivorDTO);
		        return new ResponseEntity<SurvivorDTO>(survivorDTO, HttpStatus.OK);
		    }
*/
}
