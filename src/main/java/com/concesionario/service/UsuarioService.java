package com.concesionario.service;

import com.concesionario.domain.Usuario;
import java.util.List;

/**
 *
 * @author Jorge Alfaro
 */
public interface UsuarioService {
    
    //obtener toda la informacion del usuario
    public List<Usuario> getInformacion(int idUsuario);
    
 
    //guardar informacion que se modifique o info nueva
    public void save(Usuario usuario);
    
    
    //eliminar el usuario si es necesario
    public void delete(Usuario usuario);
    
    Usuario validateUser(String correo, String contrasena);
    
}
