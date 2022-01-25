package org.lycancypher.api01.rest;

import java.util.List;
import java.util.Optional;

import org.lycancypher.api01.dao.ProductoDAO;
import org.lycancypher.api01.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("productos")

public class ProductoRest {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	//POST (INSERTAR)
	@PostMapping("/guardar") //localhost:8080/productos/guardar
	public void guardar (@RequestBody Producto producto) {
		productoDAO.save(producto);
	}
		
	//GET (CONSULTAR)
	@GetMapping("/listar") //localhost:8080/productos/listar
	public List<Producto> listar () {
		return productoDAO.findAll();
	}
	
	//GET (CONSULTAR POR ID)
	@GetMapping("/mostrar/{id}") //localhost:8080/productos/mostrar/id
	public Optional<Producto> mostrar (@PathVariable("id") Integer id) {
		return productoDAO.findById(id);
	}
		
	//DELETE (BORRAR)
	@DeleteMapping("/borrar/{id}") //localhost:8080/productos/borrar/id
	public void eliminar (@PathVariable("id") Integer id) {
		productoDAO.deleteById(id);
	}
		
	//PUT (ACTUALIZAR)
	@PutMapping("/actualizar") //localhost:8080/personas/actualizar
	public void actualizar (@RequestBody Producto producto) {
		productoDAO.save(producto);
	}
}
