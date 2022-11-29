package br.com.primeira_api.garagem.config.validacao;

public class ErroDeFomularioDto {

	private String campo;
	private String erro;
	
	public ErroDeFomularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
		
}
