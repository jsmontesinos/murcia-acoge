package com.murciaacoge.model;

import javax.persistence.*;

@Entity
public class Country {
	
	@Id
	@Column
	private String id;
	
	@Column
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
