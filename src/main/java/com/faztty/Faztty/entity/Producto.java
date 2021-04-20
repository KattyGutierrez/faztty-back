package com.faztty.Faztty.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	private String nombre;
	
	@Column(length = 30)
	private String marca;
	
	@Column
	private Float precio;
	
	@Column
	private Long puntuacion;
	
	@Column(length = 30)
	private String imagen;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNegocio", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Negocio negocio;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Long getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Long puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Negocio getNegocio() {
		return negocio;
	}

	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
