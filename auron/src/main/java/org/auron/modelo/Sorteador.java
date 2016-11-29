package org.auron.modelo;

import java.util.List;

public class Sorteador {

	private List<Participante> participantes;
	private Sorteio sorteio;

	public Sorteador(List<Participante> participantes, Sorteio sorteio) {
		this.participantes = participantes;
		this.sorteio = sorteio;
	}
	
	public void sortear(){
		
		int indiceAtual = 0;
		int totalDeParticipantes = participantes.size();
		
		while (indiceAtual < totalDeParticipantes){
			
			if (indiceAtual == totalDeParticipantes -1){
				Par par = new Par(participantes.get(indiceAtual), participantes.get(0), sorteio);
				sorteio.adicionarPar(par);
				break;
			}	

			Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceAtual + 1), sorteio);
			sorteio.adicionarPar(par);
			
			indiceAtual ++;
		}
	}
}