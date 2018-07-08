package com.github.odilonjk.springbootgraphqlexample.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.github.odilonjk.springbootgraphqlexample.model.Athlete;
import com.github.odilonjk.springbootgraphqlexample.repository.AthleteRepository;
import com.github.odilonjk.springbootgraphqlexample.service.dataFetcher.AllAthletesDataFetcher;
import com.github.odilonjk.springbootgraphqlexample.service.dataFetcher.AthleteDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	@Value("classpath:athlete.graphqls")
	Resource resource;

	private GraphQL graphQL;

	@Autowired
	private AllAthletesDataFetcher allAthletesDataFetcher;

	@Autowired
	private AthleteDataFetcher athleteDataFetcher;

	@Autowired
	private AthleteRepository athleteRepository;
	
	@PostConstruct
	public void loadSchema() throws IOException {
		loadDataIntoHSQL();
		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private void loadDataIntoHSQL() {
		Stream.of(
				new Athlete(1, "John McGregor", "Volleyball", 27, new String[]{"Puma", "AirCanada"}),
				new Athlete(2, "Helena Souza", "Judo", 23, new String[]{"BadGirl", "Pretorian", "Nutrilatina"}),
				new Athlete(3, "Milena Springberg", "Snowboarding", 23, new String[]{"NorthFace", "HSBC", "Red Bull"}),
				new Athlete(4, "Edgar Lestrade", "Tennis", 25, new String[]{"Xbox", "Monster"})
		).forEach(athlete -> athleteRepository.save(athlete));
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring
				.newRuntimeWiring().type("Query", typeWiring -> typeWiring
						.dataFetcher("allAthletes", allAthletesDataFetcher)
						.dataFetcher("athlete", athleteDataFetcher))
				.build();
	}
	
	public GraphQL getGraphQL() {
		return graphQL;
	}
	
}
