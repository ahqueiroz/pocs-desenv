package br.com.caelum.livraria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="livro", schema="livraria")
@NamedQueries({ 
		@NamedQuery(name = "Livro.findAll", query = "select l from Livro l"),
		@NamedQuery(name = "Livro.buscarLivroPeloNome", query = "select l from Livro l where l.titulo like :nome") 
	})

public class Livro {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	
	@ManyToOne
	private Autor autor;
	
	public Livro() {
	}

	public Livro(String titulo, Autor autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
