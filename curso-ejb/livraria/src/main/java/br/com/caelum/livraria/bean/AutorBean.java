package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.service.AutorService;

@Model
@RequestScoped
public class AutorBean {
	
	private Autor autor = new Autor();

	@Inject
	private AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.service.adicionar(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.service.bucarAutores();
	}
}
