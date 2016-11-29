package org.auron.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.auron.modelo.Sorteio;

@Named
@RequestScoped
public class SorteioBean {

	private Sorteio sorteio = new Sorteio();

	public Sorteio getSorteio(){
		return sorteio;
	}
	
	public void sortear(){
		System.out.println("teste"+sorteio.getNome());
	}
	
}
