package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.LivroService;

@WebService
@Stateless
public class LivrariaWS {
	
	@Inject
	LivroService service;	

	@WebResult(name="livros")
	public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String nome){
		
		return service.buscarLivrosPeloNome(nome);
	}
}
