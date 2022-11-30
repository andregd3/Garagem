package br.com.primeira_api.garagem.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.primeira_api.garagem.modelo.enums.Marcas;
import br.com.primeira_api.garagem.modelo.enums.StatusSituacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="carros")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String modelo;

	private String cor;

	private Integer ano;

	private BigDecimal valorCompra;

	private BigDecimal valorVenda;

	private BigDecimal lucro;
	
	@Enumerated(EnumType.STRING)
	private Marcas marca;

	@Enumerated(EnumType.STRING)
	private StatusSituacao situacao;

}
