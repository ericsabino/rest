package br.com.ems.avaliacao.rest.itauRest;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.ems.avaliacao.rest.itauRest.dto.CartaoDTO;
import br.com.ems.avaliacao.rest.itauRest.dto.ClienteDTO;
import br.com.ems.avaliacao.rest.itauRest.dto.ServicosDTO;
import br.com.ems.avaliacao.rest.itauRest.model.Cliente;
import br.com.ems.avaliacao.rest.itauRest.repository.CartaoRepository;
import br.com.ems.avaliacao.rest.itauRest.repository.ClienteRepository;
import br.com.ems.avaliacao.rest.itauRest.utils.EnumProduto;
import br.com.ems.avaliacao.rest.itauRest.utils.EnumTipoCartao;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItauRestApplicationTests {

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	public void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);
		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testAddCliente() throws Exception {		
		LocalDate dataNascimento = LocalDate.of(1990, Month.JANUARY, 3);
		
		CartaoDTO cartaoDTO1 = new CartaoDTO(1, EnumTipoCartao.CREDITO, "9999888877776666", Instant.now(), true);
		CartaoDTO cartaoDTO2 = new CartaoDTO(2, EnumTipoCartao.CREDITO, "1111222244443333", Instant.now(), true);
		
		ServicosDTO servicosDTO = new ServicosDTO(1, EnumProduto.CONSIGNADO, Instant.now());
		
		ClienteDTO clienteDTO = new ClienteDTO(1, "TESTE UNITARIO", "12312312399", dataNascimento, 'M', true, Arrays.asList(cartaoDTO1, cartaoDTO2), Arrays.asList(servicosDTO), Instant.now());
		
		 this.mockMvc.perform(post("/api/itau/add")
	                .content(this.json(clienteDTO))
	                .contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	                .andExpect(content().json(this.json(clienteDTO)));
		 			
	}
	
	@Test
    public void testAtualizaCliente() throws Exception {
		ClienteDTO clienteDTO = new ClienteDTO();
		Cliente cliente = clienteRepository.findById(1);
		BeanUtils.copyProperties(cliente, clienteDTO);

		clienteDTO.setNome("ERIC SABINO");
        String cpf = "12312312399";
		this.mockMvc.perform(put("/api/itau/update/" + cpf + "/" )
                .param("nome", "ERIC SABINO"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(this.json(clienteDTO)));
    }
	
	@Test
	public void testFindClientes() throws Exception {
		this.mockMvc.perform(get("/api/itau/list"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk());
	}
	
	@Test
    public void testRemoveCliente() throws Exception {
		ClienteDTO clienteDTO = new ClienteDTO();
		Cliente cliente = clienteRepository.findById(1);
		BeanUtils.copyProperties(cliente, clienteDTO);

        String cpf = "12312312399";
		this.mockMvc.perform(delete("/api/itau/delete/" + cpf + "/" ));
    }
	
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}
