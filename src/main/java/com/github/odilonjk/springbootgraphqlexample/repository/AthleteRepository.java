package com.github.odilonjk.springbootgraphqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.odilonjk.springbootgraphqlexample.model.Athlete;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {

}
