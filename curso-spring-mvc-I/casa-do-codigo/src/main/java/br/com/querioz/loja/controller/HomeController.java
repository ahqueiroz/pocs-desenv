package br.com.querioz.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(){
		
		System.out.println("tsete");
		
		return "home";
	}

}
