package com.concesionario.service.impl;

import com.concesionario.dao.UsuarioDao;
import com.concesionario.domain.Usuario;
import com.concesionario.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jorge Alfaro
 */

@Service 
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> getInformacion(int idUsuario) {
        var lista=usuarioDao.findAll();
        return lista;
    }
    
    @Override
    @Transactional
    
    public void save(Usuario usuario) {
        usuarioDao.save(usuario); //Guadar o modificar el id (marcas)
    }
    
    @Override
    @Transactional
    
    public void delete(Usuario usuario){
        usuarioDao.delete(usuario); //Eliminar el id (marcas)
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario validateUser(String correo, String contrasena) {
        return usuarioDao.findByCorreoAndContrasena(correo, contrasena);
    }
    
}
