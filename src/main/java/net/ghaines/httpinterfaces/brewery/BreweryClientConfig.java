package net.ghaines.httpinterfaces.brewery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
class BreweryClientConfig {
	@Bean
	BreweryClient openBreweryClient() {
		var restClient = RestClient.builder()
				.baseUrl("https://api.openbrewerydb.org")
				.build();
		var adapter = RestClientAdapter.create(restClient);
		var factory = HttpServiceProxyFactory.builderFor(adapter).build();
		return factory.createClient(BreweryClient.class);
	}
}
