package com.github.odilonjk.springbootgraphqlexample.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "musician_role")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicianRole {

	@Id
	private int id;
	
	private String name;
	
}
