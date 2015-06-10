package com.murciaacoge.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.murciaacoge.calculators.*;

@Entity	
@Views({
@View (name="detalleActuacionCustomer", members = "date, section, gestor; departamento, temaActuacion; estado; notas; acciones")
})
public class Actuacion {
	
	@Column @Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date date;
	
	@ManyToOne
	@DescriptionsList
	@NoCreate
	@NoModify
	@DefaultValueCalculator(SectionCalculator.class)
	private Section section;
	
	@ManyToOne
	@DescriptionsList
	@NoCreate
	@NoModify
	@Required
	private Departamento departamento;
	
	@ManyToOne
	@DescriptionsList(depends="this.departamento", condition="${departamento.id} = ?")
	@NoCreate
	@NoModify
	@Required
	private TemaActuacion temaActuacion;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	@OrderBy("date")
	@ListProperties("date, tipo.name, derivacion.name")
	@AsEmbedded
	private Collection<Accion> acciones;
	
	@Column
	@Stereotype("MEMO")
	private String notas;
	
	@ManyToOne
	@DescriptionsList
	@NoCreate
	@NoModify
	private Estado estado;
	
	@ManyToOne
	@NoCreate
	@NoModify
	@DescriptionsList
	@ReadOnly
	@DefaultValueCalculator(GestorCalculator.class)
	private Gestor gestor;

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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public TemaActuacion getTemaActuacion() {
		return temaActuacion;
	}

	public void setTemaActuacion(TemaActuacion temaActuacion) {
		this.temaActuacion = temaActuacion;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(Collection<Accion> acciones) {
		this.acciones = acciones;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}
