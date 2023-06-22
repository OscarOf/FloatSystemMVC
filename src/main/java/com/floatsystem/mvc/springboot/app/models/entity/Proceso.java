package com.floatsystem.mvc.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="procesos")
public class Proceso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "proceso_id")
	private List<Formulario> formularios;
	
	public Proceso() {
		this.formularios = new ArrayList<Formulario>();
	}  

	@PrePersist
	public void fechaCreada() {
		this.fecha = new Date();
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Formulario> getFormularios(){
		return this.formularios;
	}
	
	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
	
	public void agregarFormulario(Formulario formulario) {
		this.formularios.add(formulario);
	}
	
	public Integer cantidadForm() {
		return this.formularios.size();
	}
	
	private static final long serialVersionUID = 1L;

}
