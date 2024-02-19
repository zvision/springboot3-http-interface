package com.se.alaf.client.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.se.alaf.client.model.Post;

public interface PostClientService {

	@GetExchange("/")
	ResponseEntity<List<Post>> findAll();

	@GetExchange("/{id}")
	Post findById(@PathVariable (value ="id") Long  id);
}
