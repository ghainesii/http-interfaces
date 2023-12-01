package net.ghaines.httpinterfaces;

import net.ghaines.httpinterfaces.client.BreweryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class HttpInterfacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpInterfacesApplication.class, args);
	}

	@Bean
	BreweryClient openBreweryClient() {
		var restClient = RestClient.builder().baseUrl("https://api.openbrewerydb.org").build();
		var adapter = RestClientAdapter.create(restClient);
		var factory = HttpServiceProxyFactory.builderFor(adapter).build();
		return factory.createClient(BreweryClient.class);
	}

}
