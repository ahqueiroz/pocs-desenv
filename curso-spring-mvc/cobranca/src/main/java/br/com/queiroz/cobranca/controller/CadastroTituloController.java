package br.com.queiroz.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroTituloController {

	@GetMapping("/titulos/novo")
	public String novo(){
		return "cadastrotitulo";
	}	
}
