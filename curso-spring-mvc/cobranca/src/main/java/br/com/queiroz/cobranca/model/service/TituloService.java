package br.com.queiroz.cobranca.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.queiroz.cobranca.model.Titulo;
import br.com.queiroz.cobranca.model.repository.TituloRepository;

@Service
public class TituloService{
	
	@Autowired
	TituloRepository tituloRepository;
	
	public void salvar(Titulo titulo){
		tituloRepository.save(titulo);
	}
	
	public List<Titulo> findAll(){
		return tituloRepository.findAll();
	}
}
