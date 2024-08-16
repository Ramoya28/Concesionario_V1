/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author user
 */

@Data // especificar que es una capa de datos
@Entity// Esta clase esta enlazada a una tabla en la base de datos
@Table(name = "contacto") // Especioficar cual entidad

public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto")
    
    private Long idContacto;
    private String nombre_completo;
    private String primer_apellido ;
    private String segundo_apellido ;
    private String email ;
    private String telefono ;
    private boolean activo;

    public Contacto() {
    }

    public Contacto(String nombre_completo, boolean activo) {
        this.nombre_completo = nombre_completo;
        this.activo = activo;
    }
    
    
}
