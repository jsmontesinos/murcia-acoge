package com.murciaacoge.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.murciaacoge.calculators.*;

@Entity	
public class Accion {
	
	@Column @Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date date;
	
	@ManyToOne
	@DescriptionsList
	private TipoAccion tipo;
	
	@ManyToOne
	private Actuacion actuacion;
	
	@ManyToOne
	@DescriptionsList
	private Derivacion derivacion;
	
	@ManyToOne
	@NoCreate
	@NoModify
	@DescriptionsList
	@ReadOnly
	@DefaultValueCalculator(GestorCalculator.class)
	private Gestor gestor;
	
	@Column
	@Stereotype("MEMO")
	private String notas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TipoAccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoAccion tipo) {
		this.tipo = tipo;
	}

	public Actuacion getActuacion() {
		return actuacion;
	}

	public void setActuacion(Actuacion actuacion) {
		this.actuacion = actuacion;
	}

	public Derivacion getDerivacion() {
		return derivacion;
	}

	public void setDerivacion(Derivacion derivacion) {
		this.derivacion = derivacion;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	
	
	

}
