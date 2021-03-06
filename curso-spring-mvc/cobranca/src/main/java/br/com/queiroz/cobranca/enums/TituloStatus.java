package br.com.queiroz.cobranca.enums;

public enum TituloStatus {

	PENDENTE("Pendente"), RECEBIDO("Recebido");

	private String descricao;

	TituloStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
