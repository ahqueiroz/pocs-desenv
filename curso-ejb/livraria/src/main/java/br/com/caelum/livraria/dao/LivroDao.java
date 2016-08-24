package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) //opcional
//@Interceptors(LogInterceptador.class)
public class LivroDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED) //opcional
//	@Interceptors(LogInterceptador.class)
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	
	public List<Livro> todosLivros() {
		return entityManager.createNamedQuery("livro.findAll", Livro.class).getResultList();
	}
	
}
