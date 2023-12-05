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
public class ActualizarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecuta SQL de tipo select
        //El id proporcionado debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 1);

        //Paso 3. termina la trasaccion 1
        tx.commit();

        //Objeto en estado detache
        log.debug("Objeto recuperado:" + persona1);

        //Paso 4. setValue (nuevoValor)
        persona1.setApellido("Forero");

        //Paso5. Inicia transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //Paso 6. Modificamos el objeto
        em.merge(persona1);

        //Paso 7. Termina transaccion 2
        tx2.commit();

        //objeto en estado detached ya modificado
        log.debug("Objeto recuperado:" + persona1);

        //Cerramos el entity manager
        em.close();

    }
}
