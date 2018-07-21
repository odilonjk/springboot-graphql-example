package com.github.odilonjk.springbootgraphqlexample.service.dataFetcher;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.odilonjk.springbootgraphqlexample.model.Artist;
import com.github.odilonjk.springbootgraphqlexample.repository.ArtistRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ArtistDataFetcher implements DataFetcher<Artist> {

	@Autowired
	private ArtistRepository artistRepository;
	
	@Override
	public Artist get(DataFetchingEnvironment environment) {
		Integer id = environment.getArgument("id");
		return artistRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity with ID " + id + " wasn't found."));
	}

}
