package br.com.casadocodigo.loja.exceptions;

import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by Cristiano on 10/14/17.
 */
public class PagamentoNegadoException extends Throwable {

	private final HttpClientErrorException httpClient;

	public PagamentoNegadoException(HttpClientErrorException e) {
		httpClient = e;
	}

	public HttpClientErrorException getHttpClient() {
		return httpClient;
	}
}
