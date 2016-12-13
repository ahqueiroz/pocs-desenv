package br.com.querioz.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.querioz.loja.controller.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class })
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//O setPrefix define o caminho onde estão nossas views
		resolver.setPrefix("/WEB-INF/views/");
		//setSuffix adiciona a extenção dos arquivos de view
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
