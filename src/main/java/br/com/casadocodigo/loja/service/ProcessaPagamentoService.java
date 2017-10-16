package br.com.casadocodigo.loja.service;

import br.com.casadocodigo.loja.models.PaymentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Cristiano on 10/14/17.
 */
public class ProcessaPagamentoService {

	@Autowired
	private RestTemplate restTemplate;

	public void executa(PaymentData paymentData) {

		try {
			String uriToPay = "http://book-payment.herokuapp.com/payment";
			String response = restTemplate.postForObject(uriToPay, paymentData, String.class);
			System.out.println(response);
		} catch (HttpClientErrorException e) {
			//throw new PagamentoNegadoException(e);
		}

	}

}
