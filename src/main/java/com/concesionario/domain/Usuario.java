/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Jorge Alfaro
 */

@Data
@Entity
@Table(name= "usuario")
public class Usuario implements Serializable{
    
    private static final long seriaVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String numeroCedula;
    private String correoElectronico;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String usuario, String correoElectronico) {
        this.nombre = usuario;
        this.apellido = usuario;
        this.correoElectronico = correoElectronico;
    }

    
    
    
    
    
    
    
}
