package org.com.co.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.com.co.dao.ParPeliculas;

/**
 *
 * @author DarkKlitos
 */
@Stateless
@Path("/peliculas")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class PeliculaFacadeREST extends AbstractFacade<ParPeliculas> {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    public PeliculaFacadeREST() {
        super(ParPeliculas.class);
    }

    /**
     * Metodo que crea en la db una Pelicula
     *
     * @param entity
     */
    @POST
    @Override
    public void create(ParPeliculas entity) {
        super.create(entity);
    }

    /**
     * Metodo que modifica una Pelicula en la db
     *
     * @param id
     * @param entity
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") int id, ParPeliculas entity) {
        super.edit(entity);
    }

    /**
     * Metodo que elimina una Pelicula de la db
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    /**
     * Metodo que busca un Departamento por su id en la db
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    public ParPeliculas find(@PathParam("id") int id) {
        return super.find(id);
    }

    /**
     * Metodo que retorna todos las Pelicula de la db
     *
     * @return
     */
    @GET
    @Override
    public List<ParPeliculas> findAll() {
        return super.findAll();
    }

    /**
     * Metodo que realiza la busqueda de una Pelicula por sus atributos
     *
     * @param parametro
     * @return
     */
    @GET
    @Path("buscar/{parametro}")
    public List<ParPeliculas> search(@PathParam("parametro") String param
    ) {
        return em.createNamedQuery("ParPeliculas.findByParams")
                .setParameter("parametro", "%" + param + "%").getResultList();
    }

    /**
     * Metodo que realizar la busqueda de varias Peliculas indicandoles un
     * limite superior e inferior
     *
     * @param from
     * @param to
     * @return
     */
    @GET
    @Path("{from}/{to}")
    public List<ParPeliculas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     *
     * @return
     */
    @GET
    @Path("count")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
