package com.credibanco.assessment.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.library.model.Usuario;

public interface UsuarioDaoAPI extends CrudRepository<Usuario, Long> {

	Usuario findByUsuario(String usuario);
}
