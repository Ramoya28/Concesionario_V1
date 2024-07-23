<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.concesionario.service;

import com.concesionario.domain.Categoria;
=======
package com.concesionario.service;

>>>>>>> main
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
    
<<<<<<< HEAD
=======
    Usuario validateUser(String correo, String contrasena);
    
>>>>>>> main
}
