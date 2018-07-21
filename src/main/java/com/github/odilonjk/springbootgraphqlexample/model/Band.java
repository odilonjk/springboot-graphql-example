package com.github.odilonjk.springbootgraphqlexample.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Band {

	@Id
	private int id;

	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "band_members",
			joinColumns = @JoinColumn(name = "band_id"),
			inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private List<Artist> members;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
}
