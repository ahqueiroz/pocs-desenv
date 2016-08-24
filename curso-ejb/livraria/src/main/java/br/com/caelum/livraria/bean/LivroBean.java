package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.exception.LivrariaException;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.AutorService;
import br.com.caelum.livraria.service.LivroService;

@Model
@RequestScoped
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;
	
	@Inject
	private LivroService livroService;
	
	@Inject
	private AutorService autorService;

	public void cadastra() throws LivrariaException {
		
		Autor autor = this.autorService.buscarPeloId(this.autorId);
		this.livro.setAutor(autor);
		
		this.livroService.adicionar(livro);
		
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorService.bucarAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroService.buscarLivros();
	}
}
