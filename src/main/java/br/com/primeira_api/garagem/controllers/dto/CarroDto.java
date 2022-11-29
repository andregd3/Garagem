package br.com.primeira_api.garagem.controllers.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.primeira_api.garagem.modelo.Carro;
import br.com.primeira_api.garagem.modelo.enums.Marcas;
import br.com.primeira_api.garagem.modelo.enums.StatusSituacao;

public class CarroDto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String modelo;
	private String cor;
	private Integer ano;
	private BigDecimal valorCompra = new BigDecimal(2);
	private BigDecimal valorVenda = new BigDecimal(2);
	private BigDecimal lucro = new BigDecimal(2);
	
	@Enumerated(EnumType.STRING)
	private Marcas marca;
	
	@Enumerated(EnumType.STRING)
	private StatusSituacao situacao;
	
	public CarroDto(Carro carro) {
		this.id = carro.getId();
		this.modelo = carro.getModelo();
		this.cor = carro.getCor();
		this.ano = carro.getAno();
		this.valorCompra = carro.getValorCompra();
		this.valorVenda = carro.getValorVenda();
		this.marca = carro.getMarca();
		this.situacao = carro.getSituacao();
		this.lucro = carro.getValorVenda().subtract(valorCompra);
		}

	public Long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public Integer getAno() {
		return ano;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public Marcas getMarca() {
		return marca;
	}

	public StatusSituacao getSituacao() {
		return situacao;
	}
	
	public static List<CarroDto> converter(List<Carro> carros) {
		return carros.stream().map(CarroDto::new).collect(Collectors.toList());
	}

}
