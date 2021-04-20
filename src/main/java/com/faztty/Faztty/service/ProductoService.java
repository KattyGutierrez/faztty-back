package com.faztty.Faztty.service;

import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.bean.ProductoBean;
import com.faztty.Faztty.entity.Categoria;
import com.faztty.Faztty.entity.Negocio;
import com.faztty.Faztty.entity.Producto;
import com.faztty.Faztty.repository.CategoriaRepository;
import com.faztty.Faztty.repository.NegocioRepository;
import com.faztty.Faztty.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository repoProducto;
	
	@Autowired
	CategoriaRepository repoCategoria;

	@Autowired
	NegocioRepository repoNegocio;

	public Iterable<Producto> getProductosByCategoriaNegocio(Long idCategoria, Long idNegocio){
		Categoria c=repoCategoria.findById(idCategoria).get();
		Negocio n=repoNegocio.findById(idNegocio).get();
		return repoProducto.findAllByCategoriaAndNegocioOrderByPuntuacionAsc(c,n);
	}
	public Iterable<ProductoBean> getProductosBeanByCategoriaNegocio(Long idCategoria, Long idNegocio){
		Categoria c=repoCategoria.findById(idCategoria).get();
		Negocio n=repoNegocio.findById(idNegocio).get();
		LinkedHashSet<ProductoBean> pbL = new LinkedHashSet<ProductoBean>();
		ProductoBean pb=new ProductoBean();
		System.out.println("Iniciando el bean");
		for (Producto p: repoProducto.findAllByCategoriaAndNegocioOrderByPuntuacionAsc(c,n)) {
			pb.setId(p.getId());
			pb.setImagen(p.getImagen());
			pb.setMarca(p.getMarca());
			pb.setNombre(p.getNombre());
			pb.setPrecio(p.getPrecio());
			pb.setPuntuacion(p.getPuntuacion());
			pb.setCategoria(p.getCategoria().getNombre());
			System.out.println(pb.toString());
			pbL.add(pb);
		}
		return pbL;
		
	}
	public Iterable<Producto> getProductosByNegocio(Long idNegocio){
		
		Negocio n=repoNegocio.findById(idNegocio).get();
		return repoProducto.findAllByNegocioOrderByPuntuacionAsc(n);
	}
	
	
}
