//package br.com.caelum.livraria.it;
//
//import static org.junit.Assert.assertEquals;
//
//import javax.inject.Inject;
//
//import org.jboss.arquillian.container.test.api.RunAsClient;
//import org.jboss.arquillian.junit.Arquillian;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import br.com.caelum.livraria.ArquillianUtil;
//import br.com.caelum.livraria.dao.UsuarioDao;
//import br.com.caelum.livraria.modelo.Usuario;
//
//@RunAsClient
//@RunWith(Arquillian.class)
//public class LivrariaIT extends ArquillianUtil{
//
//	@Inject
//	UsuarioDao usuarioDao;
//	
//	@Test
//	public void recuperarUsuarioLogin(){
//		String login = "admin";
//		Usuario usuario = usuarioDao.buscaPeloLogin(login);
//		assertEquals(login, usuario.getLogin());
//	}
//}
