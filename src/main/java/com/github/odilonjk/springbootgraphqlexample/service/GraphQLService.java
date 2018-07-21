package com.github.odilonjk.springbootgraphqlexample.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.github.odilonjk.springbootgraphqlexample.service.dataFetcher.AllArtistsDataFetcher;
import com.github.odilonjk.springbootgraphqlexample.service.dataFetcher.ArtistDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	@Value("classpath:artist.graphqls")
	Resource resource;

	private GraphQL graphQL;

	@Autowired
	private AllArtistsDataFetcher allArtistsDataFetcher;

	@Autowired
	private ArtistDataFetcher artistDataFetcher;

	@PostConstruct
	public void loadSchema() throws IOException {
		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring
				.newRuntimeWiring().type("Query", typeWiring -> typeWiring
						.dataFetcher("allArtists", allArtistsDataFetcher)
						.dataFetcher("artist", artistDataFetcher))
				.build();
	}

	public GraphQL getGraphQL() {
		return graphQL;
	}

}
