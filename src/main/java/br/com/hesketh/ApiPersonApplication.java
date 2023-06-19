package br.com.hesketh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiPersonApplication extends WebSecurityConfigurerAdapter {

	@Value("${spring.profiles.active}")
	private String perfilAmbiente;

	private static final String AMBIENTE_PRD = "PRD";

	private static final String[] urlSwagger = {
			"/v2/api-docs/**",
			"/v3/api-docs/**",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/swagger-ui.html"
	};

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));

		SpringApplication.run(ApiPersonApplication.class, args);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/actuator/**").permitAll()
				.antMatchers("/data/person/**").permitAll();

		if (!perfilAmbiente.equalsIgnoreCase(AMBIENTE_PRD)) {
			http.authorizeRequests().antMatchers(urlSwagger).permitAll();
		}

		http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
