/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclovidaJPA;

import domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;



/**
 *
 * @author PC 4060TI
 */
public class ActualizarObjetoSesionLarga {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso. ejecutamos SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        log.debug("Objecto encontrado:" + persona1);
        
        //Paso 3. setValue(nuevoValor)
        persona1.setEmail("jjuarez@mail.com");
        
        persona1.setEmail("camanrofo@mail.com");
        
        //Paso 4. Termina la transaccion 1
        tx.commit();
        
        //Objeto en estado detached
        log.debug("objeto modificado:" + persona1);

        //Cerramos el entity manager
        em.close();

    }
}
