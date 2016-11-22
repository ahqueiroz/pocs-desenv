package org.auron.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.auron.modelo.Participante;

@Stateless
public class ParticipanteDao {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Participante participante){
		em.persist(participante);
	}
}
