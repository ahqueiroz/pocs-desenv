package br.com.queiroz.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.queiroz.cobranca.enums.CadastroPaginas;
import br.com.queiroz.cobranca.enums.TituloStatus;
import br.com.queiroz.cobranca.model.Titulo;
import br.com.queiroz.cobranca.model.service.TituloService;

@Controller
@RequestMapping("/titulos")
public class CadastroTituloController {

	@Autowired
	private TituloService service;

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(CadastroPaginas.PAGINA_CADASTRO_TITULO.getDescricao());
		return mv;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {

		ModelAndView mv = new ModelAndView();
		
		service.salvar(titulo);
		
		mv.addObject("mensagem", "Titulo salvo com sucesso");
		mv.setViewName(CadastroPaginas.PAGINA_CADASTRO_TITULO.getDescricao());

		return mv;
	}

	@GetMapping
	public ModelAndView pesquisar() {
		
		ModelAndView mv = new ModelAndView(CadastroPaginas.PAGINA_PESQUISA_TITULO.getDescricao());
		
		List<Titulo> titulos = service.findAll();
		
		mv.addObject("titulos", titulos);
		
		return mv;
	}

	@ModelAttribute("tituloStatus")
	public List<TituloStatus> getTituloStatus() {
		return Arrays.asList(TituloStatus.values());
	}
}