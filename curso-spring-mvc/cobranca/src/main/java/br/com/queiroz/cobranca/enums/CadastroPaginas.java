package br.com.queiroz.cobranca.enums;

public enum CadastroPaginas {
	
	PAGINA_CADASTRO_TITULO("cadastro-titulo"), 
	PAGINA_PESQUISA_TITULO("pesquisa-titulo");
	
	private String descricao;
	
	CadastroPaginas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
