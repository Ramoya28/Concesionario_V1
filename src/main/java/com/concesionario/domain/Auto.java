package com.concesionario.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author gabri
 */

@Data //especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la bd
@Table(name = "auto") //Especificar cual entidad

public class Auto implements Serializable{
        
    private static final long seriaVersionUID = 1L; // Auto incremento en Java MySQL (AUTO_INCREMENT)  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")

    private Long idAuto;
    private String marca;
    private String modelo;
    private String estilo;
    private String combustible;
    private String transmision;
    private String provincia;    
    private int ano;   
    private float precio; 
    private String rutaImagen;
    private boolean activo;    
    
    public Auto() {
    }    

    public Auto(long idAuto, String marca, String modelo, String estilo, String combustible, String transmision, String provincia, int ano, float precio, String rutaImagen, boolean activo) {
        this.idAuto = idAuto;
        this.marca = marca;
        this.modelo = modelo;
        this.estilo = estilo;
        this.combustible = combustible;
        this.transmision = transmision;
        this.provincia = provincia;
        this.ano = ano;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
}
