package br.com.queiroz.cobranca.model.service;

import java.util.List;

import br.com.queiroz.cobranca.model.Titulo;

public interface ITituloService {
	
	public void salvar(Titulo titulo);
	
	public List<Titulo> findAll();
	
	public void excluir (Long codigo);

	public String receber(Long codigo);
}
