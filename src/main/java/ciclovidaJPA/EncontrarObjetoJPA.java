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
public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        //Paso 3. termina la transaccion
        tx.commit();
       
        //Objeto en estado de detached
        log.debug("Objeto recuperado:" + persona1);
        
        //Cerramos el entity manager
        em.close();
    }
}
