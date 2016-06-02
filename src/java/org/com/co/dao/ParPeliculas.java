package org.com.co.dao;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gdaimon
 */
@Entity
@Table(name = "par_peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParPeliculas.findAll", query = "SELECT p FROM ParPeliculas p"),
    @NamedQuery(name = "ParPeliculas.findById", query = "SELECT p FROM ParPeliculas p WHERE p.id = :id"),
    @NamedQuery(name = "ParPeliculas.findByCodigo", query = "SELECT p FROM ParPeliculas p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "ParPeliculas.findByNombre", query = "SELECT p FROM ParPeliculas p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ParPeliculas.findByDescripcion", query = "SELECT p FROM ParPeliculas p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParPeliculas.findByParams", query = "SELECT p"
            + "  FROM ParPeliculas p"
            + "  WHERE lower(p.nombre) like :parametro")})
public class ParPeliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public ParPeliculas() {
    }

    public ParPeliculas(Integer id) {
        this.id = id;
    }

    public ParPeliculas(Integer id, int codigo, String nombre, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof ParPeliculas)) {
            return false;
        }
        ParPeliculas other = (ParPeliculas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.com.co.dao.ParPeliculas[ id=" + id + " ]";
    }

}
