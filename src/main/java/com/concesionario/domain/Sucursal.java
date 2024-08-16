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

@Data //especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la bd
@Table(name = "sucursales") //Especificar cual entidad
public class Sucursal implements Serializable{
    
    private static final long seriaVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    
    private long idSucursal;
    private String nombreSucursal;
    private String ubicacion;
    private String horarioApertura;
    private String horarioCierre;
    private String numeroTelefono;

    public Sucursal() {
    }

    public Sucursal(long idSucursal, String nombreSucursal, String ubicacion, String horarioApertura, String horarioCierre, String numeroTelefono) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.ubicacion = ubicacion;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.numeroTelefono = numeroTelefono;
    }
    
    
    
    
    
}
