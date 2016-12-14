package org.auron.modelo;

import java.util.ArrayList;
import java.util.List;

import org.auron.controller.SorteadorController;
import org.auron.exception.SorteioException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorteadorTest extends ConstrutorDeDados{
	
	private int quantidade = 3;	
	private List<Participante> participantes;	
	private Sorteio sorteio;
	
	@Before
	public void setUp() throws Exception {
		participantes = getParticipantes(quantidade);
		sorteio = new Sorteio();
	}

	@Test(expected=SorteioException.class)
	public void naoDeveExistirUmaListaDeParticipantesComMenosDeDoisParticipantes() throws SorteioException{
		SorteadorController sorteador = new SorteadorController(participantes, sorteio);
		sorteador.sortear();
	}
	
	@Test
	public void aQuantidadeDeParesEParticipantesDeveSerAMesma() throws SorteioException {
		
		int quantidadeDeParticipantes = participantes.size();
		
		SorteadorController sorteador = new SorteadorController(participantes, sorteio);
		sorteador.sortear();
		
		int quantidadeDePares = sorteio.getQuantidadeDePares();
		
		Assert.assertTrue(quantidadeDePares == quantidadeDeParticipantes);
	}
	
	@Test
	public void naoDeveHaverAmigosOcultosDuplicados() throws SorteioException{
		
		SorteadorController sorteador = new SorteadorController(participantes, sorteio);
		sorteador.sortear();
		
		List<Par> pares = new ArrayList<>(sorteio.getPares());
		
		for (int i = 0; i < pares.size(); i++) {
			
			Participante  amigoOculto = pares.get(i).getAmigoOculto();
			
			Participante proximoAmigoOculto = i < pares.size() - 1 ? pares.get(i + 1).getAmigoOculto() : pares.get(0).getAmigoOculto();
			
			Assert.assertFalse(amigoOculto.equals(proximoAmigoOculto));
		}
	}
	
	@Test(expected=SorteioException.class)
	public void naoAceitarUmaListaDeParticipantesVazia() throws SorteioException{
		SorteadorController sorteador = new SorteadorController(participantes, sorteio);
		sorteador.sortear();
	}
	
	@Test
	public void ultimoAmigoOcultoEhIgualAoPrimeiroParticipante() throws SorteioException{
		
		SorteadorController sorteador = new SorteadorController(participantes, sorteio);
		sorteador.sortear();
		
		List<Par> pares = new ArrayList<>(sorteio.getPares());
		
		Par parPrimeiro = pares.get(0);
		Par parUltimo = pares.get(pares.size()-1);
		
		Assert.assertEquals(parPrimeiro.getAmigo(), parUltimo.getAmigoOculto());
	}
}
