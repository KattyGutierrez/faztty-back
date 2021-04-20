package com.faztty.Faztty.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType = DiscriminatorType.STRING)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(unique = true, length = 30)
	public String username;
	@Column(unique = true, length = 30)
	public String email;
	@Column(length = 60)
	public String password;
	
	
}
