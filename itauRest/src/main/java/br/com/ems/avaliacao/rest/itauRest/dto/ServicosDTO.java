package br.com.ems.avaliacao.rest.itauRest.dto;

import java.time.Instant;

import br.com.ems.avaliacao.rest.itauRest.utils.EnumProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ServicosDTO {
	private Integer id;
	private EnumProduto servicosBanco;
	private Instant data;

}
