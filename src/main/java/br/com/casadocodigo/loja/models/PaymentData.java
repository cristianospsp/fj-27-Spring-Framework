package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

/**
 * Created by Cristiano on 10/14/17.
 */
public class PaymentData {

	private final BigDecimal total;

	public PaymentData(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Payment{");
		sb.append("total=").append(total);
		sb.append('}');
		return sb.toString();
	}
}
