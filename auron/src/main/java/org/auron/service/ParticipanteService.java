package org.auron.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
import org.auron.dao.ParticipanteDao;
import org.auron.modelo.Participante;

@Stateless
public class ParticipanteService {

	@Inject
	private ParticipanteDao dao;
	
	private List<Participante> participantes;

	public void inserir(Participante participante) {
		dao.inserir(participante);
	}

	public List<Participante> getParticipantes() {
		if(CollectionUtils.isEmpty(participantes)){
			participantes = dao.getParticipantes(); 
		}
		return participantes;
	}

	public Participante getParticipante(String email, String senha) {
		return dao.getParticipante(email, senha);
	}

}
