package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.commons.GenericServiceImpl;
import com.credibanco.assessment.library.dao.LibrosDaoAPI;
import com.credibanco.assessment.library.model.Libros;
import com.credibanco.assessment.library.service.LibrosServiceAPI;

@Service
public class LibrosServiceImpl extends GenericServiceImpl<Libros, Integer> implements LibrosServiceAPI {

	@Autowired
	private LibrosDaoAPI librosDaoAPI;
	
	@Override
	public CrudRepository<Libros, Integer> getDao() {
		return librosDaoAPI;
	}

}
