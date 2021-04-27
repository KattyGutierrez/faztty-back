package com.faztty.Faztty.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.LinkedHashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.faztty.Faztty.bean.FotoBean;
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
	
	@PersistenceContext
	private EntityManager entityManager;

	public Iterable<Producto> getProductosByCategoriaNegocio(Long idCategoria, Long idNegocio) throws FileNotFoundException, SQLException, IOException{
		Categoria c=repoCategoria.findById(idCategoria).get();
		Negocio n=repoNegocio.findById(idNegocio).get();
		Iterable<Producto> listp = repoProducto.findAllByCategoriaAndNegocioOrderByPuntuacionAsc(c,n);
		for(Producto p: listp) {
			p.setImagen_ruta(downloadFoto3(p.getImagen_blob()));
			p.setImagen_blob(null);
		}
			
		return listp;
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
	public Iterable<Producto> getProductosByNegocio(Long idNegocio) throws FileNotFoundException, SQLException, IOException{
		
		Negocio n=repoNegocio.findById(idNegocio).get();
		Iterable<Producto> listp = repoProducto.findAllByNegocioOrderByPuntuacionAsc(n);
		for(Producto p: listp) {
			//System.out.println(p.getImagen_blob());
			//if(p.getImagen_blob()!=null)
				p.setImagen_ruta(downloadFoto3(p.getImagen_blob()));
			p.setImagen_blob(null);
			
		}
		return listp;
	}
	
	public Producto getProducto(Long idProducto) throws FileNotFoundException, SQLException, IOException {
		Producto p = repoProducto.findById(idProducto).get();
		//p.setImagen_ruta(downloadFoto3(p.getImagen_blob()));
		p.setImagen_blob(null);
		return p;
	}
	
	public Producto agregarProducto(Long id_negocio,ProductoBean pb) {
		Producto p = new Producto();
		p.setCategoria(repoCategoria.findById(pb.getCatid()).get());
		p.setImagen(pb.getImagen());
		p.setMarca(pb.getMarca());
		p.setNombre(pb.getNombre());
		p.setPrecio(pb.getPrecio());
		p.setPuntuacion((long)50);
		p.setNegocio(repoNegocio.findById(id_negocio).get());
		repoProducto.save(p);
		p.setImagen_blob(null);
		return p;
	}
	
	public Producto modificarProducto(ProductoBean pb, Long id) {
		Producto p= repoProducto.findById(id).get();
		p.setCategoria(repoCategoria.findById(pb.getCatid()).get());
		p.setImagen(pb.getImagen());
		p.setMarca(pb.getMarca());
		p.setNombre(pb.getNombre());
		p.setPrecio(pb.getPrecio());
		
		repoProducto.save(p);
		p.setImagen_blob(null);
		
		return p;
	}

	public Producto uploadFoto(MultipartFile archivo, Long id) {

		Producto p= repoProducto.findById(id).get();
		try {

			FileInputStream fis = new FileInputStream(convert(archivo));

			Session session = entityManager.unwrap(Session.class);
			Blob blob = session.getLobHelper().createBlob(fis, convert(archivo).length());
			
			String imagen = archivo.getOriginalFilename();
			
			p.setImagen(imagen);
			p.setImagen_blob(blob);
			
			

			repoProducto.save(p);
			p.setImagen_blob(null);
			p.setImagen_ruta(downloadFoto2(archivo));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	public FotoBean downloadFoto(Long id) throws SQLException {
		FotoBean bean = new FotoBean(); 
		Producto p= repoProducto.findById(id).get();
		String cadena = "";
		if(p.getImagen_blob()!=null) {
			System.out.println("Entrando...");
			byte[] archivo = p.getImagen_blob().getBytes(1, (int) p.getImagen_blob().length());
			cadena = Base64.getEncoder().encodeToString(archivo);
		}
		bean.setFoto(cadena);
		return bean;
	}
	public String downloadFoto2(MultipartFile archivo) throws SQLException, FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(convert(archivo));

		Session session = entityManager.unwrap(Session.class);
		Blob blob = session.getLobHelper().createBlob(fis, convert(archivo).length());
		String cadena = "../assets/img/producto.png";
		if(blob!=null) {
			System.out.println("Entrando...");
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			cadena = "data:"+archivo.getContentType()+";base64,"+Base64.getEncoder().encodeToString(bytes);
		}
		return cadena;
	}
	public String downloadFoto3(Blob blob) throws SQLException, FileNotFoundException, IOException {
		String cadena = "../assets/img/producto.png";
		if(blob!=null) {
			System.out.println("Entrando...");
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			cadena = "data:imagen/jpg;base64,"+Base64.getEncoder().encodeToString(bytes);
		}
		return cadena;
	}
	
}
