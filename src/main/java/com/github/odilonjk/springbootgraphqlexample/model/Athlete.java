package com.github.odilonjk.springbootgraphqlexample.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {

	@Id
	private int id;

	private String name;

	private String sport;

	private int age;

	private String[] sponsors;

}
