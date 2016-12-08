package org.auron.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Par {

	public static final String MAP_SORTEIO = "sorteio";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Participante amigo;
	
	@ManyToOne
	private Participante amigoOculto;
	
	@ManyToOne
	private Sorteio sorteio;
	
	public Par(Participante amigo, Participante amigoOculto, Sorteio sorteio) {
		super();
		this.amigo = amigo;
		this.amigoOculto = amigoOculto;
		this.sorteio = sorteio;
	}
	
	Par(){
	}

	public Integer getId() {
		return id;
	}

	public Participante getAmigo() {
		return amigo;
	}

	public Participante getAmigoOculto() {
		return amigoOculto;
	}

	public Sorteio getSorteio() {
		return sorteio;
	}
}
