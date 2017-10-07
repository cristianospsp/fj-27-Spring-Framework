package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Controller
@RequestMapping(value="/products")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO; 
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
	}
	
	@RequestMapping("/form")
	public ModelAndView form() {
		System.out.println("Carrega formulario...");
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public String save(Product product) {
		System.out.println("Cadastrando Produto: " + product);
		productDAO.save(product);
		return "products/ok";
	}
	
	
	
}
