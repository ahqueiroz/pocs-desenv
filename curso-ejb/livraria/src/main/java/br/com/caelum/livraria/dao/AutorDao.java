package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void salva(Autor autor) {
		manager.persist(autor);
	}

	public List<Autor> todosAutores() {
		return manager.createNamedQuery("autor.findAll", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return manager.find(Autor.class, autorId);
	}
}