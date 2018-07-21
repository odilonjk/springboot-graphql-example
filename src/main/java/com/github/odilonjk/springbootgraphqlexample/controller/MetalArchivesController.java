package com.github.odilonjk.springbootgraphqlexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.odilonjk.springbootgraphqlexample.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/rest/metal-archives")
public class MetalArchivesController {

	@Autowired
	private GraphQLService graphQLService;

	@PostMapping
	public ResponseEntity<ExecutionResult> getArtists(@RequestBody String query) {
		ExecutionResult result = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
