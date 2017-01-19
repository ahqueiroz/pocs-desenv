package br.com.queiroz.cobranca.enums;

public enum CadastroPaginas {
	
	PAGINA_CADASTRO_TITULO("cadastrotitulo"), 
	PAGINA_PESQUISA_TITULO("pesquisatitulo");
	
	private String descricao;
	
	CadastroPaginas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
