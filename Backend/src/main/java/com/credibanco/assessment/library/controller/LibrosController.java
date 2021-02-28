package com.credibanco.assessment.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.credibanco.assessment.library.model.Libros;
import com.credibanco.assessment.library.service.AutoresServiceAPI;
import com.credibanco.assessment.library.service.EditorialesServiceAPI;
import com.credibanco.assessment.library.service.LibrosServiceAPI;

@Controller
@RequestMapping("/home")
public class LibrosController {

	@Autowired
	private LibrosServiceAPI libroServiceAPI;
	@Autowired
	private AutoresServiceAPI autoresServiceAPI;
	@Autowired
	private EditorialesServiceAPI editorialesServiceAPI;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", libroServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {
		
		
		model.addAttribute("autores", autoresServiceAPI.getAll());
		model.addAttribute("editoriales", editorialesServiceAPI.getAll());
		
		if (id != null && id != 0) {
			model.addAttribute("libro", libroServiceAPI.get(id));
			
		} else {
			model.addAttribute("libro", new Libros());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Libros libro, Model model) {
		libroServiceAPI.save(libro);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		libroServiceAPI.delete(id);

		return "redirect:/home/";
	}

}
