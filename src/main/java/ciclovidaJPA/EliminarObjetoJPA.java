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
public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 4);
        
        //Paso 3. termina transaccion 1
        tx.commit();
        
        //objeto en estado detached
        log.debug("objeto encontrado:" + persona1);
        
        //Paso 4. Inicia transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso 5. Ejecuta SQL que es un delete
        em.remove( em.merge(persona1));

        //Paso 6. termina transaccion 2
        tx2.commit();
        
        //objeto en estado detached ya eliminado
        log.debug("objeto eliminado:" + persona1);
        
        //Cerramos el entity manager
        em.close();

    }
}
