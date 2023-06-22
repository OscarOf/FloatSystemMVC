package com.floatsystem.mvc.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@NotNull
	private Long cedula;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	@Email
	private String correo;

	@NotNull
	private String contra;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaCrea;
	
	@OneToMany(mappedBy = "usuario" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Proceso> procesos;
	
	public Usuario() {
		this.procesos = new ArrayList<Proceso>();
	}

	public Long getCedula() {
		return this.cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContra() {
		return this.contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public Date getFechaCrea() {
		return this.fechaCrea;
	}

	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	
	public List<Proceso> getProcesos(){
		return this.procesos;
	}
	
	public void setProcesos(List<Proceso> procesos) {
		this.procesos = procesos;
	}
	
	public void agregarProceso(Proceso proceso) {//Agregar un Proceso a la vez
		this.procesos.add(proceso);
	}

	private static final long serialVersionUID = 1L;
}
