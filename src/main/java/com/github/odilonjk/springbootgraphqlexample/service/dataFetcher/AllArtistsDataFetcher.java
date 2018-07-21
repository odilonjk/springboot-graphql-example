package com.github.odilonjk.springbootgraphqlexample.service.dataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.odilonjk.springbootgraphqlexample.model.Artist;
import com.github.odilonjk.springbootgraphqlexample.repository.ArtistRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllArtistsDataFetcher implements DataFetcher<List<Artist>> {

	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public List<Artist> get(DataFetchingEnvironment environment) {
		return artistRepository.findAll();
	}

}
