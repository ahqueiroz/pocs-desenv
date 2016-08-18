package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public Usuario buscaPeloLogin(String login) {
		
		TypedQuery<Usuario> query = entityManager.createNamedQuery("usuario.findByLogin", Usuario.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}
	
}
