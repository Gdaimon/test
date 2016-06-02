package org.com.co.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import org.com.co.dao.ParPeliculas;
import org.com.co.model.Pelicula;
import org.com.co.services.PeliculaFacadeREST;

/**
 *
 * @author Gdaimon
 */
@ManagedBean
@RequestScoped
public class PeliculaBean {

    private Pelicula pelicula = new Pelicula();
    private ParPeliculas peliculadb = new ParPeliculas();
    private PeliculaFacadeREST pelRest = new PeliculaFacadeREST();
    private EntityManager em;

    public void guardarPelicula() {
        System.out.println("Funciona");
        peliculadb.setCodigo(pelicula.getCodigo());
        peliculadb.setNombre(pelicula.getNombre());
        peliculadb.setDescripcion(pelicula.getDescripcion());
        pelRest.create(peliculadb);
    }

    public String irImagen() {
        return "imagen";
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    protected EntityManager getEntityManager() {
        return em;
    }
}
