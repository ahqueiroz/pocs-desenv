package org.auron.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.auron.dao.ParticipanteDao;
import org.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {

	@Inject
	private Participante participante;
	
	@Inject
	ParticipanteDao participanteDao;

	public void cadastrar(){
		participanteDao.inserir(participante);
	}
	
	public Participante getParticipante() {
		return participante;
	}
}
