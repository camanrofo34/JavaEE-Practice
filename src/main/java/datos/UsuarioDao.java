/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.Usuario;
import java.util.List;

/**
 *
 * @author PC 4060TI
 */
public interface UsuarioDao {

    public List<Usuario> findAllUsuarios();

    public Usuario findUsuarioById(Usuario usuario);

    public void insertUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);

}
