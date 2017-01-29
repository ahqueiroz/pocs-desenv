package br.com.queiroz.cobranca.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.queiroz.cobranca.enums.TituloStatus;
import br.com.queiroz.cobranca.model.Titulo;
import br.com.queiroz.cobranca.model.repository.TituloRepository;
import br.com.queiroz.cobranca.model.repository.filter.TituloFilter;

@Service
public class TituloService implements ITituloService {

	@Autowired
	TituloRepository tituloRepository;

	public void salvar(Titulo titulo) {
		try{
			tituloRepository.save(titulo);
		}catch (DataIntegrityViolationException e){
			throw new IllegalArgumentException("Data inválida");
		}
	}

	public List<Titulo> findAll() {
		return tituloRepository.findAll();
	}

	public void excluir(Long codigo) {
		tituloRepository.delete(codigo);
	}

	@Override
	public String receber(Long codigo) {
		Titulo titulo = tituloRepository.findOne(codigo);
		titulo.setStatus(TituloStatus.RECEBIDO);
		salvar(titulo);
		return TituloStatus.RECEBIDO.getDescricao();
	}

	@Override
	public List<Titulo> filtrarPorCampo(TituloFilter filtro) {
		return tituloRepository.findByDescricaoContaining(filtro.getDescricao());
	}
}
