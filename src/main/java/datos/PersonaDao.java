/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.Persona;
import java.util.List;

/**
 *
 * @author PC 4060TI
 */
public interface PersonaDao {
    public List<Persona> findAllPersonas();
    
    public Persona findPersonaById(Persona persona);
    
    public Persona findPersonaByEmail (Persona persona);
    
    public void insertPersona (Persona persona);
    
    public void updatePersona (Persona persona);
    
    public void deletePersona (Persona persona);
}
