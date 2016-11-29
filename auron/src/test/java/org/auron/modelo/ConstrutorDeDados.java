package org.auron.modelo;

import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeDados {
	
	public List<Participante> getParticipantes(int quantidadeParticipantes){
		
		List<Participante> participantes = new ArrayList<>();
		
		for (int i = 0 ; i < quantidadeParticipantes; i++){
			
			Participante participante = new Participante();
			
//			if (i < quantidadeParticipantes -1){			
				participante.setUsuario("Usuario_"+i);
				participante.setEmail("Email_"+i);			
//			}else{
//				participante.setUsuario("Usuario_"+0);
//				participante.setEmail("Email_"+0);
//			}
				
			participantes.add(participante);
		}
		
		return participantes;
	}

}
