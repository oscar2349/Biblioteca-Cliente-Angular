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
@Table(name = "autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a")
    , @NamedQuery(name = "Autores.findByIdAutores", query = "SELECT a FROM Autores a WHERE a.idAutores = :idAutores")
    , @NamedQuery(name = "Autores.findByCiudadProcedencia", query = "SELECT a FROM Autores a WHERE a.ciudadProcedencia = :ciudadProcedencia")
    , @NamedQuery(name = "Autores.findByCorreoElectronico", query = "SELECT a FROM Autores a WHERE a.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Autores.findByFechaNacimento", query = "SELECT a FROM Autores a WHERE a.fechaNacimento = :fechaNacimento")
    , @NamedQuery(name = "Autores.findByNombreCompleto", query = "SELECT a FROM Autores a WHERE a.nombreCompleto = :nombreCompleto")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_autores")
    private Integer idAutores;
    @Column(name = "ciudad_procedencia")
    private String ciudadProcedencia;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "fecha_nacimento")
    private String fechaNacimento;
    @Basic(optional = false)
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    public Autores() {
    }

    public Autores(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public Autores(Integer idAutores, String nombreCompleto) {
        this.idAutores = idAutores;
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getFechaNacimento() {
        return fechaNacimento;
    }

    public void setFechaNacimento(String fechaNacimento) {
        this.fechaNacimento = fechaNacimento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutores != null ? idAutores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.idAutores == null && other.idAutores != null) || (this.idAutores != null && !this.idAutores.equals(other.idAutores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sun2.Enum3a.Autores[ idAutores=" + idAutores + " ]";
    }
    
}
