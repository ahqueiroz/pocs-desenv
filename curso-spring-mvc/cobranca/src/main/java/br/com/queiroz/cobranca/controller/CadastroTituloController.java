package br.com.queiroz.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		mv.addObject(new Titulo());
		mv.setViewName(CadastroPaginas.PAGINA_CADASTRO_TITULO.getDescricao());
		return mv;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes redirectAttributes) {
	
		//verifica se tem erros
		if (errors.hasErrors())
			return CadastroPaginas.PAGINA_CADASTRO_TITULO.getDescricao();
		
		service.salvar(titulo);
	
		//armazena o objeto em uma sessão temporária para que seja enviado juntamento com o redirect
		redirectAttributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso");

		//redireciona para uma nova requisição
		return "redirect:/titulos/novo";
	}
	
	//nome do parametro passado
	// identificando o atributo do @PathVariable("codigo") o spring executa
	// uma consulta do objeto apartir do código passado
	// Só faz isso pq está sendo utilizado o JPA repository
	@RequestMapping("{codigo}")
	public ModelAndView edicao (@PathVariable("codigo") Titulo titulo){
		
		ModelAndView mv = new ModelAndView(CadastroPaginas.PAGINA_CADASTRO_TITULO.getDescricao());
		//retorna o objeto recuperado da base para a pagina de cadastro/edição
		mv.addObject(titulo);
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