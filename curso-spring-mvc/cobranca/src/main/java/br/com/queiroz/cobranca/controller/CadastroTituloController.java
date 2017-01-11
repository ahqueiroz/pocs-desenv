package br.com.queiroz.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.queiroz.cobranca.model.Titulo;
import br.com.queiroz.cobranca.model.service.TituloService;

@Controller
@RequestMapping("/titulos")
public class CadastroTituloController {
	
	@Autowired
	private TituloService service;

	@GetMapping("/novo")
	public String novo(){
		return "cadastrotitulo";
	}	
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo){
		
		ModelAndView mv = new ModelAndView("cadastrotitulo");
		
		service.salvar(titulo);
		
		mv.addObject("mensagem","Titulo salvo com sucesso");
		
		return mv;		
	}
}
