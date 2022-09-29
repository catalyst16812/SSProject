package com.catalyst.funds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


//		@Bean
//	  public ViewResolver viewResolver() {
//	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//	    templateResolver.setTemplateMode("XHTML");
//	    templateResolver.setPrefix("views/");
//	    templateResolver.setSuffix(".html");
//
//	    SpringTemplateEngine engine = new SpringTemplateEngine();
//	    engine.setTemplateResolver(templateResolver);
//
//	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	    viewResolver.setTemplateEngine(engine);
//	    return viewResolver;
//	  }
}