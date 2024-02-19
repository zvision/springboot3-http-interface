package com.se.alaf.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.se.alaf.client.service.PostClientService;

public class ClientConfig {

	@Bean
	PostClientService postClientService() {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080/api").build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
		return factory.createClient(PostClientService.class);
	}

}