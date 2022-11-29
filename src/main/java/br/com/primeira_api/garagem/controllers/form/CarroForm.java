package br.com.primeira_api.garagem.controllers.form;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import br.com.primeira_api.garagem.modelo.Carro;
import br.com.primeira_api.garagem.modelo.enums.Marcas;
import br.com.primeira_api.garagem.modelo.enums.StatusSituacao;
import br.com.primeira_api.garagem.repository.CarroRepository;

public class CarroForm {
	
	@NotNull @Length(min = 2)
	private String modelo;
	
	@NotNull @Length(min = 4)
	private String cor;
	
	@NotNull
	private Integer ano;
	
	@NotNull
	private BigDecimal valorCompra = new BigDecimal(2);
	
	@NotNull
	private BigDecimal ValorVenda = new BigDecimal(2);
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Marcas marca;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusSituacao situacao;
	
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
		return ValorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		ValorVenda = valorVenda;
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

	public Carro converter(CarroRepository repository) {
		return new Carro(modelo, cor, ano, valorCompra, ValorVenda, marca, situacao);
	}
	
	public Carro update(Long id, CarroRepository repository) {
		Carro carro = repository.getReferenceById(id);
		
		carro.setModelo(modelo);
		carro.setCor(cor);
		carro.setAno(ano);
		carro.setValorCompra(valorCompra);
		carro.setValorVenda(ValorVenda);
		
		return carro;
		
	}

}
