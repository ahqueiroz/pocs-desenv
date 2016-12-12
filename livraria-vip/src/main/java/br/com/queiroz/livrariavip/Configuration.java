package br.com.queiroz.livrariavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Configuration {

	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);
	}

	//Essa configuração não é necessário.. a configuração está definida no arquivo application.properties
//	@Bean
//	public DataSource getDataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//
//		return dataSource;
//	}
}
