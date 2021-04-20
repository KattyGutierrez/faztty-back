package com.faztty.Faztty.bean;



public class ProductoBean {
	
	
	private Long id;
	private String nombre;
	private String marca;
	private Float precio;
	private Long puntuacion;
	private String imagen;
	private String categoria;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "ProductoBean [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio
				+ ", puntuacion=" + puntuacion + ", imagen=" + imagen + ", categoria=" + categoria + "]";
	}
	
}
