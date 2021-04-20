package com.faztty.Faztty.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@DiscriminatorValue("N")

public class Negocio extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true, length = 30)
	private String RUC;

	@Column(unique = true, length = 30)
	private String nombre;
	
	@Column
	private Long puntuacion;
	
	@Column(length = 30)
	private String imagen;
	
	@Column(length = 100)
	private String direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoNegocio", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoNegocio tipoNegocio;

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String rUC) {
		RUC = rUC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
}
