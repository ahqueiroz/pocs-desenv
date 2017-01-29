package br.com.queiroz.cobranca.model.repository.filter;

public class TituloFilter {
	
	private String descricao;

	public String getDescricao() {
		
		if (descricao == null)
			return "%";
		
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
