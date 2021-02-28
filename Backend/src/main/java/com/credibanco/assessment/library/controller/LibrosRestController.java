package com.credibanco.assessment.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.model.Libros;
import com.credibanco.assessment.library.service.AutoresServiceAPI;
import com.credibanco.assessment.library.service.EditorialesServiceAPI;
import com.credibanco.assessment.library.service.LibrosServiceAPI;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
@Slf4j
public class LibrosRestController {

	@Autowired
	private LibrosServiceAPI libroServiceAPI;
	@Autowired
	private AutoresServiceAPI autoresServiceAPI;
	@Autowired
	private EditorialesServiceAPI editorialesServiceAPI;

	@GetMapping(value = "/all")
	public List<Libros> getAll() {
		return libroServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Libros find(@PathVariable Integer id) {
		return libroServiceAPI.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Libros> save(@RequestBody Libros libro) {
				
		//libro.setAutoresIdAutores(autoresServiceAPI.get(libro.getAutoresIdAutores().getIdAutores()));
		//libro.setEditorialesIdEditoriales(editorialesServiceAPI.get(libro.getEditorialesIdEditoriales().getIdEditoriales()));
		Libros obj = libroServiceAPI.save(libro);
		return new ResponseEntity<Libros>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Libros> delete(@PathVariable Integer id) {
		Libros libro = libroServiceAPI.get(id);
		if (libro != null) {
			libroServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Libros>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Libros>(libro, HttpStatus.OK);
	}

}
