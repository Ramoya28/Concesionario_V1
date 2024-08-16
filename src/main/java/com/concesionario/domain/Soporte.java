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
@Table(name = "soporte") // Especioficar cual entidad

public class Soporte implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSoporte")
    
    private Long idSoporte;
    private String titulo;
    private String descripcion;
    private String nombre_completo;
      private String telefono ;
    private String email ;
    private boolean activo;

    public Soporte() {
    }

    public Soporte(Long idSoporte, String titulo, String descripcion, String nombre_completo, String telefono, String email, boolean activo) {
        this.idSoporte = idSoporte;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombre_completo = nombre_completo;
        this.telefono = telefono;
        this.email = email;
        this.activo = activo;
    }

   

    
}
