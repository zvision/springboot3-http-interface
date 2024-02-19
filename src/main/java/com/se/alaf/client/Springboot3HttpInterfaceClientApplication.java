package com.se.alaf.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.se.alaf.client.service.PostClientService;

@SpringBootApplication
public class Springboot3HttpInterfaceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3HttpInterfaceClientApplication.class, args);
	}

	@Bean
	PostClientService postClientService() {
		RestClient client = RestClient.create("https://jsonplaceholder.typicode.com/posts");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();
		return factory.createClient(PostClientService.class);
	}
}
