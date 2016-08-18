package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	AutorDao autorDao;

	public void adicionar(Autor autor){		
		autorDao.salva(autor);
	}

	public List<Autor> bucarAutores() {
		return autorDao.todosAutores();
	}

	public Autor buscarPeloId(Integer autorId){
		return autorDao.buscaPelaId(autorId);
	}
}
