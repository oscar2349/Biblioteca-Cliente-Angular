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
@Table(name = "editoriales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editoriales.findAll", query = "SELECT e FROM Editoriales e")
    , @NamedQuery(name = "Editoriales.findByIdEditoriales", query = "SELECT e FROM Editoriales e WHERE e.idEditoriales = :idEditoriales")
    , @NamedQuery(name = "Editoriales.findByCorreoElectronico", query = "SELECT e FROM Editoriales e WHERE e.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Editoriales.findByDireccion", query = "SELECT e FROM Editoriales e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Editoriales.findByMaximoLibrosRegistrados", query = "SELECT e FROM Editoriales e WHERE e.maximoLibrosRegistrados = :maximoLibrosRegistrados")
    , @NamedQuery(name = "Editoriales.findByNombre", query = "SELECT e FROM Editoriales e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Editoriales.findByTelefono", query = "SELECT e FROM Editoriales e WHERE e.telefono = :telefono")})
public class Editoriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_editoriales")
    private Integer idEditoriales;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "maximo_libros_registrados")
    private String maximoLibrosRegistrados;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;

    public Editoriales() {
    }

    public Editoriales(Integer idEditoriales) {
        this.idEditoriales = idEditoriales;
    }

    public Editoriales(Integer idEditoriales, String direccion, String maximoLibrosRegistrados, String nombre) {
        this.idEditoriales = idEditoriales;
        this.direccion = direccion;
        this.maximoLibrosRegistrados = maximoLibrosRegistrados;
        this.nombre = nombre;
    }

    public Integer getIdEditoriales() {
        return idEditoriales;
    }

    public void setIdEditoriales(Integer idEditoriales) {
        this.idEditoriales = idEditoriales;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMaximoLibrosRegistrados() {
        return maximoLibrosRegistrados;
    }

    public void setMaximoLibrosRegistrados(String maximoLibrosRegistrados) {
        this.maximoLibrosRegistrados = maximoLibrosRegistrados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditoriales != null ? idEditoriales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editoriales)) {
            return false;
        }
        Editoriales other = (Editoriales) object;
        if ((this.idEditoriales == null && other.idEditoriales != null) || (this.idEditoriales != null && !this.idEditoriales.equals(other.idEditoriales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sun2.Enum3a.Editoriales[ idEditoriales=" + idEditoriales + " ]";
    }
    
}
