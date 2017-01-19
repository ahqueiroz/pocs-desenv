package br.com.queiroz.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.queiroz.cobranca.enums.CadastroPaginas;

@Controller
@RequestMapping("/titulos")
public class PesquisaTituloController {
	
	
	@RequestMapping("/pesquisa")
	public ModelAndView pesquisa(){
		ModelAndView mv = new ModelAndView(CadastroPaginas.PAGINA_PESQUISA_TITULO.getDescricao());
		return mv;
	}
	
}
