package com.murciaacoge.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.murciaacoge.calculators.*;

@Entity
@View (members = "datosRegistro [fechaAcogida, section, numeroExpediente; gestor, acceso];" +
	   		     "datosPersonales [name, surname; idcardnumber; address; phone, email; sex, nacimiento; country, dobleNacionalidad, annoEntrada; enpadronamiento, tarjetaSanitaria; level, situacion];" +
			     "notas; actuaciones")
public class Customer {

	@SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	private Long id;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaAcogida;

	@ManyToOne
	@DescriptionsList
	@NoCreate
	@NoModify
	@Required
	@DefaultValueCalculator(SectionCalculator.class)
	private Section section;

	@Column
	@Hidden
	private String year;

	@Column
	@Hidden
	private Long number;

	@Column(length = 50)
	@Required
	private String name;

	@Column
	private String surname;

	@Column
	private String idcardnumber;
	
	@Column
	private String address;
	
	@Column
	@Digits(integer=13, fraction=0)
	@Stereotype("TELEPHONE")
	private String phone;
	
	@Column
	@Email
	@Stereotype("EMAIL")
	private String email;
	
	@Column
	private Sex sex;
	
	@Column
	private Date nacimiento;

	@ManyToOne
	@NoCreate
	@NoModify
	@DescriptionsList
	@ReadOnly
	@DefaultValueCalculator(GestorCalculator.class)
	private Gestor gestor;
	
	@ManyToOne
	@DescriptionsList
	@NoCreate
	@NoModify
	private Country country;
	
	@Column
	private Boolean dobleNacionalidad;
	
	@Column
	private Integer annoEntrada;
	
	@Column
	private Boolean enpadronamiento;
	
	@Column
	private Boolean tarjetaSanitaria;
	
	@ManyToOne
	@DescriptionsList
	private EducationLevel level;
	
	@ManyToOne
	@DescriptionsList
	private Acceso acceso;
	
	@ManyToOne
	@DescriptionsList
	private SituacionDocumental situacion;

	@Hidden
	@DefaultValueCalculator(CurrentDateCalculator.class)
	@Stereotype("DATETIME")
	private Date date;
	
	@AsEmbedded
	@OneToMany (mappedBy="customer")
	@OrderBy("date")
	@CollectionView(forViews="DEFAULT", value="detalleActuacionCustomer")
	@ListProperties("date, section.name, departamento.name, temaActuacion.name, estado.name")
	private Collection<Actuacion> actuaciones;
	
	@Column
	@Stereotype("MEMO")
	private String notas;

	@PrePersist
	private void calculateNumber() {
		year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		Query query = XPersistence.getManager().createQuery(
				"select max(c.number) from " + getClass().getSimpleName()
						+ " c where c.year = :year and c.section = :section");
		query.setParameter("year", year);
		query.setParameter("section", section);
		Integer lastNumber = (Integer) query.getSingleResult();
		this.setNumber(Long.valueOf(lastNumber == null ? 1 : lastNumber + 1));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdcardnumber() {
		return idcardnumber;
	}

	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNumeroExpediente() {
		return this.getSection().getId() + "-" + this.getYear() + "-"
				+ this.getNumber();
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public Integer getAnnoEntrada() {
		return annoEntrada;
	}

	public void setAnnoEntrada(Integer annoEntrada) {
		this.annoEntrada = annoEntrada;
	}

	public Boolean getEnpadronamiento() {
		return enpadronamiento;
	}

	public void setEnpadronamiento(Boolean enpadronamiento) {
		this.enpadronamiento = enpadronamiento;
	}

	public Boolean getTarjetaSanitaria() {
		return tarjetaSanitaria;
	}

	public void setTarjetaSanitaria(Boolean tarjetaSanitaria) {
		this.tarjetaSanitaria = tarjetaSanitaria;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public EducationLevel getLevel() {
		return level;
	}

	public void setLevel(EducationLevel level) {
		this.level = level;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public SituacionDocumental getSituacion() {
		return situacion;
	}

	public void setSituacion(SituacionDocumental situacion) {
		this.situacion = situacion;
	}

	public Boolean getDobleNacionalidad() {
		return dobleNacionalidad;
	}

	public void setDobleNacionalidad(Boolean dobleNacionalidad) {
		this.dobleNacionalidad = dobleNacionalidad;
	}

	public Collection<Actuacion> getActuaciones() {
		return actuaciones;
	}

	public void setActuaciones(Collection<Actuacion> actuaciones) {
		this.actuaciones = actuaciones;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Date getFechaAcogida() {
		return fechaAcogida;
	}

	public void setFechaAcogida(Date fechaAcogida) {
		this.fechaAcogida = fechaAcogida;
	}

	
	

}
