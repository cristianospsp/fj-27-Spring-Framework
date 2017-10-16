package br.com.casadocodigo.loja.controller;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.*;
import br.com.casadocodigo.loja.service.ProcessaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * Created by Cristiano on 10/14/17.
 */
@Controller
@RequestMapping(value = "/shopping")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ShoppingCartController {

	@Autowired
	private ProductDAO dao;

	@Autowired
	private ShoppingCart carrinho;

	@Autowired
	private ProcessaPagamentoService pagamentoService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(Integer productId, BookType bookType) {
		ShoppingItem item = createItem(productId, bookType);
		carrinho.add(item);

		return new ModelAndView("redirect:/products");
	}

	private ShoppingItem createItem(Integer productId, BookType bookType) {
		Product product = dao.find(productId);
		ShoppingItem item = new ShoppingItem(product, bookType);
		return item;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView items() {
		ModelAndView modelAndView = new ModelAndView("shoppingCart/items");
		return modelAndView;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout() {
		BigDecimal total = carrinho.getTotal();

		try {
			pagamentoService.executa(new PaymentData(total));
			return "redirect:/products";
		} catch (HttpClientErrorException e) {
			System.out.println("Ocorreu um erro ao criar o Pagamento... " + e.getMessage());
			return "redirect:/shopping";
		}

	}




}
