package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.commons.GenericServiceImpl;
import com.credibanco.assessment.library.dao.EditorialesDaoAPI;
import com.credibanco.assessment.library.model.Editoriales;
import com.credibanco.assessment.library.service.EditorialesServiceAPI;

@Service
public class EditorialesServiceImpl extends GenericServiceImpl<Editoriales, Integer> implements EditorialesServiceAPI {

	@Autowired
	private EditorialesDaoAPI editorialesDaoAPI;
	
	@Override
	public CrudRepository<Editoriales, Integer> getDao() {
		return editorialesDaoAPI;
	}

}
