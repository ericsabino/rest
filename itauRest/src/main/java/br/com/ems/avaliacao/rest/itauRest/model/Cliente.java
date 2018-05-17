package br.com.ems.avaliacao.rest.itauRest.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(indexes = { @Index(name = "idx_cpf_cliente", columnList = "cpf") }, uniqueConstraints=@UniqueConstraint(columnNames="cpf"))
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer id;
	
	@Column(length = 80)
	@Getter @Setter
	private String nome;
	
	@Column(name="cpf",length = 15)
	@Getter @Setter
	private String cpf;
	
	@Getter @Setter
	private Integer idade;
	
	@Getter @Setter
	private Character sexo;
	
	@Getter @Setter
	private Boolean ativo;

	@OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="cartaoCliente",  
     joinColumns={@JoinColumn(name="idCliente", 
      referencedColumnName="id")},  
     inverseJoinColumns={@JoinColumn(name="idCartao", 
       referencedColumnName="id")})  
	@Getter @Setter
	private List<Cartao> cartoes;

	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="servicosCliente",  
    joinColumns={@JoinColumn(name="idCliente", 
     referencedColumnName="id")},  
    inverseJoinColumns={@JoinColumn(name="idServico", 
      referencedColumnName="id")})  
	@Getter @Setter
	private List<Servicos> servicos;

	@Getter @Setter
	private Instant dataCadastro;
}
