package com.github.odilonjk.springbootgraphqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.odilonjk.springbootgraphqlexample.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
