/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credibanco.assessment.library.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oramirez
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l")
    , @NamedQuery(name = "Libros.findByIdLibro", query = "SELECT l FROM Libros l WHERE l.idLibro = :idLibro")
    , @NamedQuery(name = "Libros.findByGenero", query = "SELECT l FROM Libros l WHERE l.genero = :genero")
    , @NamedQuery(name = "Libros.findByNumeroPaginas", query = "SELECT l FROM Libros l WHERE l.numeroPaginas = :numeroPaginas")
    , @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Libros.findByYear", query = "SELECT l FROM Libros l WHERE l.year = :year")
    , @NamedQuery(name = "Libros.findByAutoresIdAutores", query = "SELECT l FROM Libros l WHERE l.autoresIdAutores = :autoresIdAutores")
    , @NamedQuery(name = "Libros.findByEditorialesIdEditoriales", query = "SELECT l FROM Libros l WHERE l.editorialesIdEditoriales = :editorialesIdEditoriales")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    
    @Basic(optional = false)
    @Column(name = "numero_paginas")
    private String numeroPaginas;
    
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "year")
    private String year;
    
    @Basic(optional = false)
    @Column(name = "autores_id_autores")
    private int autoresIdAutores;
    
    @Basic(optional = false)
    @Column(name = "editoriales_id_editoriales")
    private int editorialesIdEditoriales;

    public Libros() {
    }

    public Libros(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libros(Integer idLibro, String genero, String numeroPaginas, String titulo, int autoresIdAutores, int editorialesIdEditoriales) {
        this.idLibro = idLibro;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
        this.titulo = titulo;
        this.autoresIdAutores = autoresIdAutores;
        this.editorialesIdEditoriales = editorialesIdEditoriales;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAutoresIdAutores() {
        return autoresIdAutores;
    }

    public void setAutoresIdAutores(int autoresIdAutores) {
        this.autoresIdAutores = autoresIdAutores;
    }

    public int getEditorialesIdEditoriales() {
        return editorialesIdEditoriales;
    }

    public void setEditorialesIdEditoriales(int editorialesIdEditoriales) {
        this.editorialesIdEditoriales = editorialesIdEditoriales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sun2.Enum3a.Libros[ idLibro=" + idLibro + " ]";
    }
    
}
