package com.murciaacoge.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Gestor {
	
	@Id
	@Column
	private String login;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@ManyToOne
	@DescriptionsList
	private Section section;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	

}
