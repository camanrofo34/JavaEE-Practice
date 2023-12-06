/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criteria;

import domain.Persona;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author PC 4060TI
 */
public class pruebaapiCriteria {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;

        //Api Criteria
        //1. Consulta de todas las personas
        //Paso 1. Crear instancia de criteria
        cb = em.getCriteriaBuilder();
        //Paso2. Crear objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        //Paso3. Creamos el objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        //Paso4. Seleccionar lo necesario del from
        criteriaQuery.select(fromPersona);
        //Paso5. Creamos el query typesafe
        query = em.createQuery(criteriaQuery);
        //Paso 6. Ejecutar la consulta
        personas = query.getResultList();

        mostrarPersonas(personas);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
}
