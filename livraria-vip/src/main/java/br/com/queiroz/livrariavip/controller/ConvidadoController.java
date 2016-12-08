package br.com.queiroz.livrariavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.queiroz.livrariavip.model.Convidado;
import br.com.queiroz.livrariavip.service.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaConvidados")
	public String listaConvidados(Model model){
		
		Iterable<Convidado> convidados = service.buscarConvidados();
		
		model.addAttribute("convidados", convidados);
		
		return "listaConvidados";
	}
}
