package de.cbrachem.example.samesitecookiedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SamesitecookiedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamesitecookiedemoApplication.class, args);
	}

	@Bean
	public CookieSameSiteSupplier cookieSameSiteSupplier() {
		return CookieSameSiteSupplier.ofStrict();
	}

}
