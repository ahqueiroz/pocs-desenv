package br.com.queiroz.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EnviadorEmailService {

	public void enviar(String nome, String emailDestinatario) {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("queirozsilva.alessandro@gmail.com", "eternoamor"));
			email.setSSLOnConnect(true);

			email.setFrom("queirozsilva.alessandro@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
			email.addTo(emailDestinatario);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
