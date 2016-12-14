package org.auron.modelo;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="sorteio")
public class Sorteio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String nome;
	
	@OneToMany(mappedBy=Par.MAP_SORTEIO, cascade=CascadeType.PERSIST)
	private Set<Par> pares;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Par> getPares() {
		if (CollectionUtils.isEmpty(this.pares)){
			this.pares = new LinkedHashSet<>();
		}
		return Collections.unmodifiableSet(this.pares);
	}

	public void setPares(Set<Par> pares) {
		this.pares = pares;
	}
	
	public void adicionarPar(Par par){
		this.pares.add(par);
	}

	public int getQuantidadeDePares() {		
		return this.pares.size();
	}
}