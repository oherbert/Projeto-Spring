package com.herbert.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.herbert.cursomc.domain.Categoria;
import com.herbert.cursomc.services.CategoriaService;

@RestController

//@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	//@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@GetMapping("/categoria/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
