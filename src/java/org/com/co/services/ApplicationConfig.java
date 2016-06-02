package org.com.co.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Gdaimon
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.com.co.services.PeliculaFacadeREST.class);
        resources.add(org.com.co.services.ImagenFacadeREST.class);
    }
}
