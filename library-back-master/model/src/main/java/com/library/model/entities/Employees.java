package com.library.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name ="employees")
public class Employees implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long employee_id;
	
	@Column(name="lastname")
	//@Size(message="Le nom d'utilisateur doit comporter au moins 3 lettres",min=3)
	private String lastName;

	@Column(name="firstname")
	@NotNull
	private String firstName;

	@Column(name="email", unique=true)
	//@Size(message = "L'email de l'utilisateur doit comporter au moins une lettre",min = 1)
	//@Pattern(message = "L'email n'est pas valide", regexp = "[^@]+@[^@]+")
	private String email;

	@Column(name="password")
	@NotNull
	//@Size(message = "Le mot de passe de l'utilisateur doit comporter au moins 6 lettres",min = 6)
	private String password;

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
