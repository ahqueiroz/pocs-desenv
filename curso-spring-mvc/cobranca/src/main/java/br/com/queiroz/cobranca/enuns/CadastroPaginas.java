package br.com.queiroz.cobranca.enuns;

public enum CadastroPaginas {
	
	PAGINA_CADASTRO_TITULO("cadastrotitulo");
	
	private String descricao;
	
	CadastroPaginas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
