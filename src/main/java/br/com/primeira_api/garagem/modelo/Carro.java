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

@Entity
@Table(name="carros")
public class Carro {
	
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
	
	
	
	public Carro() {
		
	}

	public Carro(String modelo, String cor, Integer ano, BigDecimal valorCompra, BigDecimal valorVenda, Marcas marca,
			StatusSituacao situacao) {
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.marca = marca;
		this.situacao = situacao;
	}

	@Enumerated(EnumType.STRING)
	private StatusSituacao situacao;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public StatusSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusSituacao situacao) {
		this.situacao = situacao;
	}
	
	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}
	
	public BigDecimal getLucro() {
		return lucro;
	}
	
}
