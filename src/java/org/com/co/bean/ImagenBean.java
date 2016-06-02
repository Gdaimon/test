/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.co.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import org.com.co.dao.ParImagen;
import org.com.co.dao.ParPeliculas;
import org.com.co.model.Imagen;
import org.com.co.services.ImagenFacadeREST;

/**
 *
 * @author Gdaimon
 */
@ManagedBean
@RequestScoped
public class ImagenBean {

    private ParImagen parImagen = new ParImagen();
    private Imagen imagen = new Imagen();
    private ImagenFacadeREST imgRest = new ImagenFacadeREST();
    private EntityManager em;
    private List<SelectItem> listPeliculas = new ArrayList<>();
    private ParPeliculas pelicula = new ParPeliculas();

    public void guardarImagen() {
        parImagen.setNombreImagen(imagen.getNombreImagen());
        parImagen.setArchivo(imagen.getArchivo());
        parImagen.setIdPelicula(pelicula.getId());
        imgRest.create(parImagen);
    }

    public List<ParPeliculas> getListPeliculas() {
        List<ParPeliculas> lisTemp = em.createNamedQuery("SELECT p FROM ParPeliculas p").getResultList();
        for (int i = 0; i < lisTemp.size(); i++) {
            this.listPeliculas.add(new SelectItem(pelicula.getId(), pelicula.getNombre()));

        }
        return lisTemp;
    }

    public void setListPeliculas(List<SelectItem> listPeliculas) {
        this.listPeliculas = listPeliculas;
    }

    public ParPeliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(ParPeliculas pelicula) {
        this.pelicula = pelicula;
    }

    public ParImagen getParImagen() {
        return parImagen;
    }

    public void setParImagen(ParImagen parImagen) {
        this.parImagen = parImagen;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public ImagenFacadeREST getImgRest() {
        return imgRest;
    }

    public void setImgRest(ImagenFacadeREST imgRest) {
        this.imgRest = imgRest;
    }

    protected EntityManager getEntityManager() {
        return em;
    }
}
