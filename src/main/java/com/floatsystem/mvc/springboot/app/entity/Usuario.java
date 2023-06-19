package com.floatsystem.mvc.springboot.app.entity;

public class Usuario {
	 
	private Integer id;
	private String name;
	private String email;
	
	public Usuario() {		
	}
	
	public Usuario(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
