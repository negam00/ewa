package nl.hva.web.workshops.restaurant.rest.config;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The application config
 * 
 * @author Wouter, Artjom, Corniels
 */
@ApplicationPath("services/rest")
public class App extends ResourceConfig {
    
    public App() {
    }
    
    
    
}
