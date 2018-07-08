package com.github.odilonjk.springbootgraphqlexample.service.dataFetcher;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.odilonjk.springbootgraphqlexample.model.Athlete;
import com.github.odilonjk.springbootgraphqlexample.repository.AthleteRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AthleteDataFetcher implements DataFetcher<Athlete> {

	@Autowired
	private AthleteRepository athleteRepository;
	
	@Override
	public Athlete get(DataFetchingEnvironment environment) {
		Integer id = environment.getArgument("id");
		return athleteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity with ID " + id + " wasn't found."));
	}

}
