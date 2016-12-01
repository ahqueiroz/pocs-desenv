package org.auron.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.auron.modelo.Sorteio;

@Stateless
public class SorteioDao {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Sorteio sorteio){
		em.persist(sorteio);
	}
	
	public Sorteio getSorteio(){		
		return (Sorteio) em.createNativeQuery(" from Sorteio", Sorteio.class).getSingleResult();
	}
	
}
