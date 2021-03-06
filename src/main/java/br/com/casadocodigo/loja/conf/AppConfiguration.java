package br.com.casadocodigo.loja.conf;

import br.com.casadocodigo.loja.controller.FileSaver;
import br.com.casadocodigo.loja.models.ShoppingCart;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controller.HomeController;
import br.com.casadocodigo.loja.daos.ProductDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProductDAO.class, FileSaver.class, ShoppingCart.class})
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver i = new InternalResourceViewResolver();
		i.setPrefix("/WEB-INF/views/");
		i.setSuffix(".jsp");
		i.setExposedContextBeanNames("shoppingCart");
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

	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService dFCService = new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
		registrar.registerFormatters(dFCService);
		return dFCService;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
