package org.auron.shiro;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.auron.modelo.Participante;
import org.auron.service.ParticipanteService;

public class Autenticador implements Realm {

	ParticipanteService participanteService;

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernameToken = (UsernamePasswordToken) token;

		String email = usernameToken.getUsername();
		String senha = new String(usernameToken.getPassword());

		Participante participante = participanteService.getParticipante(email, senha);

		if (participante != null) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(email, senha, getName());
			return info;
		}
		throw new AuthenticationException();
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return true;
	}

	public ParticipanteService getParticipanteService() {
		Properties props = new Properties();

		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		try {
			InitialContext ctx = new InitialContext(props);
			ParticipanteService service = (ParticipanteService) ctx.lookup("java:module/ParticipanteService");
			return service;
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

}
