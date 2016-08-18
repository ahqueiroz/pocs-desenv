package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	AutorDao autorDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionar(Autor autor){		
		autorDao.salva(autor);
		throw new RuntimeException("Erro lançado para testar rollback da transação.");
	}

	public List<Autor> bucarAutores() {
		return autorDao.todosAutores();
	}

	public Autor buscarPeloId(Integer autorId){
		return autorDao.buscaPelaId(autorId);
	}
}
