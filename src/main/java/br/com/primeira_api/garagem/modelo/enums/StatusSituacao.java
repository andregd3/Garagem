package br.com.primeira_api.garagem.modelo.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusSituacao {
	
	A_VENDA("0"),
	VENDIDO("1"),
	EM_PREPARACAO("2"),
	RESERVADO("3");
	
	private String statusSituacao;
	
	private static final Map<String, StatusSituacao> statusPorValor = new HashMap<>();
	
	static {
		for (StatusSituacao status : StatusSituacao.values()) {
			statusPorValor.put(status.getStatusSituacao(), status);
		}
	}
	
	private StatusSituacao(String statusSituacao) {
		this.statusSituacao = statusSituacao;
	}
	
	public String getStatusSituacao() {
		return statusSituacao;
	}
	
	public static StatusSituacao pegarStatusPorValor(String status) {
		return statusPorValor.get(status);
	}

}
