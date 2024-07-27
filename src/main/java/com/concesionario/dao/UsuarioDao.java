package com.concesionario.dao;


import com.concesionario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT u FROM Usuario u WHERE u.correoElectronico = :correo AND u.contrasena = :contrasena")
    Usuario findByCorreoAndContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena);
   
}
