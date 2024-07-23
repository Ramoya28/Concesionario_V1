<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
=======
>>>>>>> main
package com.concesionario.dao;


import com.concesionario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

/**
 *
 * @author Jorge Alfaro
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT u FROM Usuario u WHERE u.correoElectronico = :correo AND u.contrasena = :contrasena")
    Usuario findByCorreoAndContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena);
    
>>>>>>> main
}
