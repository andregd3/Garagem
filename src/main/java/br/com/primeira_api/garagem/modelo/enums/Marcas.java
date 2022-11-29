package br.com.primeira_api.garagem.modelo.enums;

import java.util.HashMap;
import java.util.Map;

public enum Marcas {
	
	GM_CHEVROLET("0"),
	VOLKSWAGEN("1"),
	FIAT("2") ,
	HYUNDAI("3"),
	RENAULT("4"),
	FORD("5");
	
	private String marcas;
	
	private static final Map<String, Marcas> marcasPorValor = new HashMap<>();
	
	static {
		for (Marcas marcas : Marcas.values()) {
			marcasPorValor.put(marcas.getMarcas(), marcas);
		}
	}
	
	private Marcas(String marcas) {
		this.marcas = marcas;
	}
	
	public String getMarcas() {
		return marcas;
	}
	
	public static Marcas pegaMarcasPorValor(String marcas) {
		return marcasPorValor.get(marcas);
	}
	
}
