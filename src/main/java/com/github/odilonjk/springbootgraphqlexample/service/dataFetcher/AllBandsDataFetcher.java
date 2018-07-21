package com.github.odilonjk.springbootgraphqlexample.service.dataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.odilonjk.springbootgraphqlexample.model.Band;
import com.github.odilonjk.springbootgraphqlexample.repository.BandRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBandsDataFetcher implements DataFetcher<List<Band>> {

	@Autowired
	private BandRepository bandRepository;
	
	@Override
	public List<Band> get(DataFetchingEnvironment environment) {
		return bandRepository.findAll();
	}

}
