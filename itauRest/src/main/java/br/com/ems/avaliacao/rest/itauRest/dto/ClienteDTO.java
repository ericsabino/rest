package br.com.ems.avaliacao.rest.itauRest.dto;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ClienteDTO {
	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	private Character sexo;
	private Boolean ativo;
	private List<CartaoDTO> cartoes;
	private List<ServicosDTO> servicos;
	private Instant dataCadastro;

	public ClienteDTO(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

}
