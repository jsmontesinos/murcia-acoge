package com.murciaacoge.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class Departamento {

	@Column
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column
	private String name;
	
	@OneToMany (mappedBy="departamento")
	private Collection<TemaActuacion> temas;
	
	@OneToMany (mappedBy="departamento")
	private Collection<TipoAccion> tipoAcciones;

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

	public Collection<TemaActuacion> getTemas() {
		return temas;
	}

	public void setTemas(Collection<TemaActuacion> temas) {
		this.temas = temas;
	}

	public Collection<TipoAccion> getTipoAcciones() {
		return tipoAcciones;
	}

	public void setTipoAcciones(Collection<TipoAccion> tipoAcciones) {
		this.tipoAcciones = tipoAcciones;
	}

}
