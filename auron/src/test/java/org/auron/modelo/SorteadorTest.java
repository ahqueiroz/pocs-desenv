package org.auron.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorteadorTest extends ConstrutorDeDados{
	
	private int quantidade = 5;	
	private List<Participante> participantes;	
	private Sorteio sorteio;
	
	@Before
	public void setUp() throws Exception {
		participantes = getParticipantes(quantidade);
		sorteio = new Sorteio();
	}

	@Test
	public void aQuantidadeDeParesEParticipantesDeveSerAMesma() {
		
		int quantidadeDeParticipantes = participantes.size();
		
		Sorteador sorteador = new Sorteador(participantes, sorteio);
		sorteador.sortear();
		
		int quantidadeDePares = sorteio.getQuantidadeDePares();
		
		Assert.assertTrue(quantidadeDePares == quantidadeDeParticipantes);
	}
	
	@Test
	public void naoDeveHaverAmigosOcultosDuplicados(){
		
		Sorteador sorteador = new Sorteador(participantes, sorteio);
		sorteador.sortear();
		
		List<Par> pares = new ArrayList<>(sorteio.getPares());
		
		for (int i = 0; i < pares.size(); i++) {
			
			Participante  amigoOculto = pares.get(i).getAmigoOculto();
			
			Participante proximoAmigoOculto = i < pares.size() - 1 ? pares.get(i + 1).getAmigoOculto() : pares.get(0).getAmigoOculto();
			
			Assert.assertFalse(amigoOculto.equals(proximoAmigoOculto));
		}
	}

}
