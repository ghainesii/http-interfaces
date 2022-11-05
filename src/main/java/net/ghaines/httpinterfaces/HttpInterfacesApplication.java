package net.ghaines.httpinterfaces;

import net.ghaines.httpinterfaces.client.BreweryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class HttpInterfacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpInterfacesApplication.class, args);
	}

	@Bean
	HttpClientAdapter httpClientAdapter(WebClient.Builder builder) {
		return WebClientAdapter
				.forClient(builder.baseUrl("https://api.openbrewerydb.org").build());
	}

	@Bean
	BreweryClient openBreweryClient(HttpClientAdapter webClientAdapter) {
		return HttpServiceProxyFactory
				.builder(webClientAdapter)
				.build()
				.createClient(BreweryClient.class);
	}

}
