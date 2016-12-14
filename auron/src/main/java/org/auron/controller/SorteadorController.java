package org.auron.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.auron.exception.SorteioException;
import org.auron.modelo.Par;
import org.auron.modelo.Participante;
import org.auron.modelo.Sorteio;


public class SorteadorController {

	private List<Participante> participantes;
	private Sorteio sorteio;

	public SorteadorController(List<Participante> participantes, Sorteio sorteio) throws SorteioException {

		if (CollectionUtils.isEmpty(participantes))
			throw new SorteioException("A lista de participantes não deve estar vazia !");
		
		this.participantes = participantes;
		this.sorteio = sorteio;
	}

	public void sortear() throws SorteioException {

		int totalDeParticipantes = participantes.size();
		
		if (CollectionUtils.isEmpty(participantes)) {
			throw new SorteioException("Deve existir ao menos 1 participante cadastrado");
		}
		
		if (totalDeParticipantes < 2){
			throw new SorteioException("O número de participantes deve ser maior que 2");
		}

		for (int indiceAtual = 0; indiceAtual < totalDeParticipantes; indiceAtual++) {

			if (isUltimoParticipanteAtual(indiceAtual, totalDeParticipantes)) {
				sorteio.adicionarPar(criarPar(indiceAtual));
				break;
			}
		}
		
	}

	private boolean isUltimoParticipanteAtual(int indiceAtual, int totalDeParticipantes) {
		return indiceAtual == totalDeParticipantes - 1;
	}

	private Par criarPar(int indiceAtual) {
		Par par = new Par(participantes.get(indiceAtual), participantes.get(0), sorteio);
		return par;
	}
}