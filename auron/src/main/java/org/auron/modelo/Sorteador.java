package org.auron.modelo;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
<<<<<<< HEAD
import org.auron.service.exception.SorteioException;
=======
import org.auron.exception.SorteioException;
>>>>>>> 748dc23cde933b2c1066983aa252bfcbaa11bee4

public class Sorteador {

	private List<Participante> participantes;
	private Sorteio sorteio;

	public Sorteador(List<Participante> participantes, Sorteio sorteio) throws SorteioException {
<<<<<<< HEAD
		if (CollectionUtils.isEmpty(participantes))
			throw new SorteioException("A lista de participantes não deve estar vazia !");
		
		this.participantes = participantes;
		this.sorteio = sorteio;
	}
	
	public void sortear() throws SorteioException{
		
		int indiceAtual = 0;
		int totalDeParticipantes = participantes.size();
		
		if (totalDeParticipantes < 2){
			throw new SorteioException("Quantidade de participantes insuficiente");
		}
		
		while (indiceAtual < totalDeParticipantes){
			
			if (indiceAtual == totalDeParticipantes -1){
				Par par = new Par(participantes.get(indiceAtual), participantes.get(0), sorteio);
				sorteio.adicionarPar(par);
				break;
			}	
=======
		if (CollectionUtils.isEmpty(participantes)) {
			throw new SorteioException("Deve existir ao menos 1 participante cadastrado");
		}
		this.participantes = participantes;
		this.sorteio = sorteio;
	}

	public void sortear() throws SorteioException {

		int totalDeParticipantes = participantes.size();
		
		if (totalDeParticipantes < 2){
			throw new SorteioException("O número de participantes deve ser maior que 2");
		}
>>>>>>> 748dc23cde933b2c1066983aa252bfcbaa11bee4

		for (int indiceAtual = 0; indiceAtual < totalDeParticipantes; indiceAtual++) {

			if (isUltimoParticipanteAtual(indiceAtual, totalDeParticipantes)) {
				sorteio.adicionarPar(criarPar(indiceAtual));
				break;
			}
			sorteio.adicionarPar(criarPar(indiceAtual));
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