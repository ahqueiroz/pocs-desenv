package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.exception.LivrariaException;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroService {

	@Inject
	LivroDao livroDao;
	
	public void adicionar(Livro livro) throws LivrariaException{		
		livroDao.salva(livro);
	}
	
	public List<Livro> buscarLivros(){
		return livroDao.todosLivros();
	}

	public List<Livro> buscarLivrosPeloNome(String nome) {
		
		return livroDao.buscarLivrosPeloNome(nome);
	}
	
}
