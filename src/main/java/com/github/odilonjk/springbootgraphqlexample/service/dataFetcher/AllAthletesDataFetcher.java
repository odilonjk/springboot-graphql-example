package com.github.odilonjk.springbootgraphqlexample.service.dataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.odilonjk.springbootgraphqlexample.model.Athlete;
import com.github.odilonjk.springbootgraphqlexample.repository.AthleteRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllAthletesDataFetcher implements DataFetcher<List<Athlete>> {

	@Autowired
	private AthleteRepository athleteRepository;

	@Override
	public List<Athlete> get(DataFetchingEnvironment environment) {
		return athleteRepository.findAll();
	}

}
