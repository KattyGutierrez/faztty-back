package com.faztty.Faztty.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;


import com.faztty.Faztty.entity.Negocio;
import com.faztty.Faztty.entity.Producto;
import com.faztty.Faztty.entity.TipoNegocio;
import com.faztty.Faztty.entity.Usuario;
import com.faztty.Faztty.bean.CompradorBean;
import com.faztty.Faztty.bean.FotoBean;
import com.faztty.Faztty.bean.NegocioBean;
import com.faztty.Faztty.bean.ProductoBean;
import com.faztty.Faztty.bean.UsuarioBean;
import com.faztty.Faztty.entity.Categoria;
import com.faztty.Faztty.entity.Comprador;
import com.faztty.Faztty.service.CategoriaService;
import com.faztty.Faztty.service.CompradorService;
import com.faztty.Faztty.service.NegocioService;
import com.faztty.Faztty.service.ProductoService;
import com.faztty.Faztty.service.TipoNegocioService;
import com.faztty.Faztty.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class NegocioController {
	
	@Autowired
	UsuarioService uService;
	
	@Autowired
	TipoNegocioService tnService;
	
	@Autowired
	NegocioService nService;
	
	@Autowired
	ProductoService pService;
	
	@Autowired
	CategoriaService cService;
	
	@Autowired
	CompradorService coService;
	
	@GetMapping({"/tipoNegocio"})
	public Iterable<TipoNegocio> consultaTipoNegocio() {
		return tnService.getTipoNegocios();
	}
	
	@GetMapping({"/tipoNegocio/{id}"})
	public TipoNegocio consultaTipoNegocio(@PathVariable Long id) {
		return tnService.getTipoNegocio(id);
	}
	@GetMapping({"/negocioByTipo/{id_tipo}"})
	public Iterable<Negocio> consultaNegocioByTipo(@PathVariable Long id_tipo) {
		return nService.getNegociosByTipo(id_tipo);
	}
	@GetMapping({"/negocio/{id}"})
	public Negocio consultaNegocio(@PathVariable Long id) {
		return nService.getNegocio(id);
	}
	@GetMapping({"/comprador/{id}"})
	public Comprador consultaComprador(@PathVariable Long id) {
		return coService.getComprador(id);
	}
	@GetMapping({"/productosByNegocio/{id_negocio}"})
	public Iterable<Producto> consultaProductoByNegocio(@PathVariable Long id_negocio) throws FileNotFoundException, SQLException, IOException {
		return pService.getProductosByNegocio(id_negocio);
	}
	@GetMapping({"/categoria"})
	public Iterable<Categoria> consultaCategoria() {
		return cService.getCategorias();
	}
	@GetMapping({"/productosByCategoria/{id_negocio}/{id_categoria}"})
	public Iterable<Producto> consultaProductoByCategoria(@PathVariable Long id_negocio, @PathVariable Long id_categoria) throws FileNotFoundException, SQLException, IOException {
		return pService.getProductosByCategoriaNegocio(id_categoria, id_negocio);
	}
	
	@GetMapping({"/producto/{id}"})
	public Producto consultaProducto(@PathVariable Long id) throws FileNotFoundException, SQLException, IOException {
		return pService.getProducto(id);
	}
	
	@PostMapping({"/registrar/n"})
	public Negocio registrarNegocio(@RequestBody NegocioBean nb) {
		return nService.registrar(nb);
	}
	@PostMapping({"/registrar/c"})
	public Comprador registrarComprador(@RequestBody CompradorBean cb) {
		return coService.registrar(cb);
	}
	
	@PostMapping({"/nuevoProducto/{id_negocio}"})
	public Producto nuevoProducto(@PathVariable Long id_negocio,@RequestBody ProductoBean pb) {
		return pService.agregarProducto(id_negocio,pb);
	}
	
	@PostMapping({"/modificarProducto/{id_producto}"})
	public Producto modificarProducto(@PathVariable Long id_producto, @RequestBody ProductoBean pb) {
		return pService.modificarProducto( pb,id_producto);
	}
	
	@DeleteMapping({"/eliminarProducto/{id_producto}"})
	public Producto eliminarProducto(@PathVariable Long id_producto) {
		return pService.eliminarProducto(id_producto);
	}
	
	@PostMapping({"/autentica"})
	public UsuarioBean login(@RequestBody UsuarioBean ub) {
		return uService.autenticacion(ub);
	}
	
	@PostMapping("/uploadFotoProducto")
	public Producto uploadFotoProducto(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("producto_id") Long id) {
		return pService.uploadFoto(archivo, id);
	}
	
	
	@GetMapping("/downloadFotoProducto/{id_producto}")
	public FotoBean downloadFotoProducto(@PathVariable Long id_producto) throws SQLException {
		return pService.downloadFoto(id_producto);
	}
	
	@PostMapping({"/modificarTipoNegocio/{id_tipo}"})
	public TipoNegocio modificarTipoNegocio(@PathVariable Long id_tipo, @RequestBody TipoNegocio tn) {
		return tnService.modificarTipoNegocio( tn,id_tipo);
	}
	
	//////////////////////////////////////////////////////////////
	@GetMapping({"/principal/{id}"})
	public String login(@PathVariable Long id,Model model) {
		
		for(TipoNegocio tn:tnService.getTipoNegocios()) {
			
			System.out.println("--"+tn.getNombre());
		}
		
		for(Negocio n:nService.getNegociosByTipo(id)) {
			System.out.println(n.getNombre());
		}
		model.addAttribute("tipoList", tnService.getTipoNegocios());
		model.addAttribute("tipoNegocio", tnService.getTipoNegocio(id));
		model.addAttribute("negocioList", nService.getNegociosByTipo(id));
		return "v_principal";
	}

	@GetMapping({"/tienda/{id1}"})
	public String tienda(@PathVariable Long id1,Model model) throws FileNotFoundException, SQLException, IOException {


		model.addAttribute("negocio", nService.getNegocio(id1));
		model.addAttribute("productoList",pService.getProductosByNegocio(id1)) ;
		model.addAttribute("categoriaList",cService.getCategorias()) ;
		return "producto_cliente";
	}
	
	@GetMapping({"/tienda/{id1}/categoria/{id2}"})
	public String tiendacategoria(@PathVariable Long id1,@PathVariable Long id2,Model model) throws FileNotFoundException, SQLException, IOException {

		for(Categoria c:cService.getCategorias()) {
			System.out.print(c.nombre);
		}
		model.addAttribute("negocio", nService.getNegocio(id1));
		model.addAttribute("productoList",pService.getProductosByCategoriaNegocio(id2, id1)) ;
		model.addAttribute("categoriaList",cService.getCategorias()) ;
		return "producto_cliente";
	}
	
	
	@GetMapping({"/mitienda"})
	public String mitienda(Model model) throws FileNotFoundException, SQLException, IOException {

		model.addAttribute("negocio", nService.getNegocio(3L));
		model.addAttribute("productoList",pService.getProductosByNegocio(3L)) ;
		model.addAttribute("categoriaList",cService.getCategorias()) ;
		return "producto_vendedor";
	}
	
	@GetMapping({"/mitienda/categoria/{id2}"})
	public String mitienda(@PathVariable Long id2,Model model) throws FileNotFoundException, SQLException, IOException {

		model.addAttribute("negocio", nService.getNegocio(3L));
		model.addAttribute("productoList",pService.getProductosByCategoriaNegocio(id2, 3L)) ;
		model.addAttribute("categoriaList",cService.getCategorias()) ;
		return "producto_vendedor";
	}
	
	

}
