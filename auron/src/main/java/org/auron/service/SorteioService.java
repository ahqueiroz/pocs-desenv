package org.auron.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.auron.dao.SorteioDao;
import org.auron.modelo.Sorteio;

@Stateless
public class SorteioService {

	@Inject
	private SorteioDao dao;

	public void inserir(Sorteio sorteio) {
		dao.inserir(sorteio);
	}

	public Sorteio getSorteio(){
		return dao.getSorteio();
	}
}
