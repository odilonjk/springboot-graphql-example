package com.github.odilonjk.springbootgraphqlexample.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Artist {

	@Id
	private int id;

	private String name;

	private Integer age;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "artist_musician_roles", 
		joinColumns = @JoinColumn(name = "artist_id"), 
		inverseJoinColumns = @JoinColumn(name = "musician_role_id"))
	private List<MusicianRole> roles;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "band_members", 
		joinColumns = @JoinColumn(name = "artist_id"), 
		inverseJoinColumns = @JoinColumn(name = "band_id"))
	private List<Band> bands;
	
}
