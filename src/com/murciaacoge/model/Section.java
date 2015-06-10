package com.murciaacoge.model;

import javax.persistence.*;

@Entity
public class Section {
	
	@Id
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String phone;
	
	@Column
	private String address;
	
	@Column
	private String city;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
