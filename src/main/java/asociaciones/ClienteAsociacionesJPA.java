/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asociaciones;

import domain.Persona;
import domain.Usuario;
import java.util.List;
import javax.persistence.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author PC 4060TI
 */
public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas=em.createNamedQuery("Persona.findAll").getResultList();
        
        em.close();
        for(Persona persona : personas){
            log.debug("Persona: "+ persona);
            for (Usuario usuario : persona.getUsuarioList()){
                log.debug("Usuario recuperado: "+usuario);
            }
        }
    }
}
