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
public class PersistirObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Paso 1. Objeto a persistir
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Luis", "Fuentes", "luisf@gmail.com", "3134678910");
        
        //Paso 2. Iniciar transaccion
        tx.begin();
        
        //Paso 3. Ejecutar sql
        em.persist(persona1);
        log.debug("Objeto persistido:"+persona1);
        //Paso 4. commit/rollback
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto persistido:"+persona1);
        
        //Cerrar
        em.close();
    }
}
