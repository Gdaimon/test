package org.com.co.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gdaimon
 */
@Entity
@Table(name = "par_imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParImagen.findAll", query = "SELECT p FROM ParImagen p"),
    @NamedQuery(name = "ParImagen.findById", query = "SELECT p FROM ParImagen p WHERE p.id = :id"),
    @NamedQuery(name = "ParImagen.findByIdPelicula", query = "SELECT p FROM ParImagen p WHERE p.idPelicula = :idPelicula"),
    @NamedQuery(name = "ParImagen.findByNombreImagen", query = "SELECT p FROM ParImagen p WHERE p.nombreImagen = :nombreImagen")})
public class ParImagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pelicula")
    private int idPelicula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_imagen")
    private String nombreImagen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "archivo")
    private byte[] archivo;

    public ParImagen() {
    }

    public ParImagen(Integer id) {
        this.id = id;
    }

    public ParImagen(Integer id, int idPelicula, String nombreImagen, byte[] archivo) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.nombreImagen = nombreImagen;
        this.archivo = archivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParImagen)) {
            return false;
        }
        ParImagen other = (ParImagen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.com.co.dao.ParImagen[ id=" + id + " ]";
    }

}
