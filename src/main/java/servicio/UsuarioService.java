/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import domain.Usuario;
import java.util.List;

/**
 *
 * @author PC 4060TI
 */
public interface UsuarioService {

    public List<Usuario> listarUsuarios();

    public Usuario encontrarUsuarioPorId(Usuario usuario);

    public void registrarUsuario(Usuario usuario);

    public void modificarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);
}
