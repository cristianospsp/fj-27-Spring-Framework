package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controller.HomeController;
import br.com.casadocodigo.loja.daos.ProductDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProductDAO.class})
public class AppConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver i = new InternalResourceViewResolver();
		i.setPrefix("/WEB-INF/views/");
		i.setSuffix(".jsp");
		return i;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}
	
}
