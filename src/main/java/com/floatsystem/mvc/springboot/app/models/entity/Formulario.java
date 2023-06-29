package com.floatsystem.mvc.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "formularios")
public class Formulario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombreform")
	private String nombreForm;//Cuidado con crear nombre con mayúsculas intermedias ya que formaria un campo así nombre_form
	private String ruta;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCrea;

	@PrePersist
	public void fechaCreacion() {
		this.fechaCrea = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreForm() {
		return nombreForm;
	}

	public void setNombreForm(String nombreForm) {
		this.nombreForm = nombreForm;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	private static final long serialVersionUID = 1L;

}
