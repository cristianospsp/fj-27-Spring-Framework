package br.com.casadocodigo.loja.controller;

import java.util.Collections;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.validations.ProductValidator;

@Controller
@RequestMapping(value="/products")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileSaver fileSaver;

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidator());
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", Optional.ofNullable(productDAO.list()).orElse(Collections.EMPTY_LIST));
		return modelAndView;
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		System.out.println("Carrega formulario...");
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST, name="saveProduct")
	public ModelAndView save(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
	                         RedirectAttributes redirectAttributes, MultipartFile summary) {
		if (bindingResult.hasErrors()) {
			return form(product); 
		}

		String webPath = fileSaver.write("upload-summaries", summary);
		product.setSummaryPath(webPath);

		productDAO.save(product);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:products");//"redirect:products";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView show(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("products/show");
		modelAndView.addObject("product", productDAO.find(id));
		return modelAndView;
	}
	
}
