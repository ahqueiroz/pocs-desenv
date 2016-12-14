package org.auron.beans;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.auron.controller.SorteadorController;
import org.auron.exception.SorteioException;
import org.auron.modelo.Par;
import org.auron.modelo.Participante;
import org.auron.modelo.Sorteio;
import org.auron.service.ParticipanteService;
import org.auron.service.SorteioService;

@Named
@RequestScoped
public class SorteioBean {

	private Sorteio sorteio = new Sorteio();
	
	@Inject
	private ParticipanteService participanteService;
		
	@Inject
	private SorteioService sorteioService;

	public Sorteio getSorteio() {
		return sorteio;
	}
	
	public Set<Par> getPares(){
		
		 Sorteio sorteio = sorteioService.getSorteio();		 
		 Set<Par> pares = sorteio.getPares();
		
		return pares;
	}

	public void sortear() {

		List<Participante> participantes = participanteService.getParticipantes();

		SorteadorController sorteador;
		try {
			sorteador = new SorteadorController(participantes, sorteio);
			sorteador.sortear();
		} catch (SorteioException e) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			e.printStackTrace();
		}
		
		
		sorteioService.inserir(sorteio);		
	}

}
