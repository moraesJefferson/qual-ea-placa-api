package br.com.gerenciador;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class QualEaPlacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualEaPlacaApplication.class, args);
	}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    factory.setMaxFileSize("124MB");
	    factory.setMaxRequestSize("124MB");
	    return factory.createMultipartConfig();
	}
}
