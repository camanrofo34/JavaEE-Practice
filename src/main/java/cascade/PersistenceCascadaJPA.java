/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cascade;

import domain.Persona;
import domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC 4060TI
 */
public class PersistenceCascadaJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 1. Crea nuevo objeto
        //objeto en estado transitivo
        Persona persona1 = new Persona("Hugo", "Hernandez", "hhernandez@mail.com", "55778822");

        //Crear objeto usuario (tiene dependencia con el objeto persona)
        Usuario usuario1 = new Usuario("hhernandez", "123", persona1);

        //Paso 3. persistimos el objeto usuario unicamente
        em.persist(usuario1);

        //Paso 4. commit transaccion
        tx.commit();

        //objetos en estados detached
        log.debug("objeto persistido persona:" + persona1);
        log.debug("objeto persistido usuario:" + usuario1);

        em.close();

    }
}
