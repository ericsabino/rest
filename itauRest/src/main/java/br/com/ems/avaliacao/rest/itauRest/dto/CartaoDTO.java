package br.com.ems.avaliacao.rest.itauRest.dto;

import java.time.Instant;

import br.com.ems.avaliacao.rest.itauRest.utils.EnumTipoCartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CartaoDTO {
	private Integer id;
	private EnumTipoCartao tipocartao;
	private String numCartao;
	private Instant dataAdesao;
	private Boolean ativo;

	public CartaoDTO(Boolean ativo) {
		super();
		this.ativo = ativo;
	}

}
