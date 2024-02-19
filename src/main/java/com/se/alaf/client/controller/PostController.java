package com.se.alaf.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.alaf.client.model.Post;
import com.se.alaf.client.service.PostClientService;

@RestController
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	PostClientService service;

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts() {
		return service.findAll();
	}

	@GetMapping("/posts/{id}")
	public Post getPostById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
}
