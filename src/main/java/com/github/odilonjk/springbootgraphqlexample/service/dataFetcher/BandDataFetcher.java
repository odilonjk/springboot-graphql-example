package com.github.odilonjk.springbootgraphqlexample.service.dataFetcher;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.odilonjk.springbootgraphqlexample.model.Band;
import com.github.odilonjk.springbootgraphqlexample.repository.BandRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BandDataFetcher implements DataFetcher<Band>{

	@Autowired
	private BandRepository bandRepository;
	
	@Override
	public Band get(DataFetchingEnvironment environment) {
		Integer id = environment.getArgument("id");
		return bandRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity with ID " + id + " wasn't found."));
	}

}
