package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN) // opcional para CONTAINER
/* CONTAINER -> CMT (Container Managed Container) usado por default. O controle do gerencimanto fica pro conta do container
 * BEAN -> BMT (Bean Managed Container) -> EJB aceita o contrele de transação programaticamente. Nesse caso 
 * já é para deixar o gerneciamento da transação explicito.
 */
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	//@TransactionAttribute(TransactionAttributeType.REQUIRED) // opcional para REQUIRED e utilizado com transactionManagemente CMT (Container0.
	/*
	 * REQUIRED -> Garante uma transação quando o método é chamado. Se não
	 * houver nenhuma transação, uma será aberta. Caso já esteja rodando, a
	 * atual será utilizada. 
	 * MANDATORY -> O container verifica se já existe uma
	 * aplicação rodando, senão, lança uma excessão. Dessa forma quem faz a
	 * chamada deve abrir uma transação
	 * REQUIRES_NEW - Indeica que sempre deve haver uma transação rodando, 
	 * caso já exista, suspende a atual para criar uma nova. Caso não exista
	 * cria uma nova.
	 * NEVER -> jamais deve haver uma transação em execução. Útil para métodos que 
	 * devem ser executados sem contexto transacional
	 */	
	@Inject
	UserTransaction tx; //Usado para quando for TransactionManagement Bean (BMT)
	/*
	 * Inteface para utilização das transações de begin e commit por exemplo.
	 */
	public void salva(Autor autor) {
		try {
			tx.begin();
			manager.persist(autor);
			tx.commit();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public List<Autor> todosAutores() {
		return manager.createNamedQuery("autor.findAll", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return manager.find(Autor.class, autorId);
	}
}