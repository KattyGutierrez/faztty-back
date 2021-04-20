package com.faztty.Faztty.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Comprador extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true, length = 30)
	private String dni;

	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30)
	private String lastName;


}
