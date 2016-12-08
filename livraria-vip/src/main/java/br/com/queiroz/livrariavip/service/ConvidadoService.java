package br.com.queiroz.livrariavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.queiroz.livrariavip.model.Convidado;
import br.com.queiroz.livrariavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired //injectado
	private ConvidadoRepository repository;
	
	public List<Convidado> buscarConvidados(){
		return (List<Convidado>) repository.findAll();
	}

}
