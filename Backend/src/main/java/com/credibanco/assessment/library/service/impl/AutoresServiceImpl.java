package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.commons.GenericServiceImpl;
import com.credibanco.assessment.library.dao.AutoresDaoAPI;
import com.credibanco.assessment.library.dao.LibrosDaoAPI;
import com.credibanco.assessment.library.model.Autores;
import com.credibanco.assessment.library.model.Libros;
import com.credibanco.assessment.library.service.AutoresServiceAPI;
import com.credibanco.assessment.library.service.LibrosServiceAPI;

@Service
public class AutoresServiceImpl extends GenericServiceImpl<Autores, Integer> implements AutoresServiceAPI {

	@Autowired
	private AutoresDaoAPI autoresDaoAPI;
	
	@Override
	public CrudRepository<Autores, Integer> getDao() {
		return autoresDaoAPI;
	}

}
