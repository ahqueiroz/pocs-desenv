package org.auron.beans;

import java.util.List;



import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.auron.modelo.Participante;
import org.auron.service.ParticipanteService;

@Named
@RequestScoped
public class ParticipanteBean {
	
	private Participante participante = new Participante();

	@Inject
	ParticipanteService participanteService;
	
	@Inject
	private Subject user;
	
	@Inject
	private FacesContext ctx;

	public void cadastrar() {
		participanteService.inserir(participante);
	}

	public Participante getParticipante() {
		return participante;
	}

	public List<Participante> getParticipantes() {
		return participanteService.getParticipantes();
	}
	
	public String login() { 
		try{
	       UsernamePasswordToken token = new UsernamePasswordToken(participante.getEmail(), participante.getSenha());
	       user = SecurityUtils.getSubject();
	       user.login(token);
	       
	       return "sorteio?faces-redirect=true";
		}catch (AuthenticationException  e) {
			ctx.addMessage(null, new FacesMessage("Email ou senha inválidos!"));
		}
		
		return null;
	}
}