package com.concesionario.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;                               

@Data //especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la bd
@Table(name = "marcas") //Especificar cual entidad

public class Categoria implements Serializable{
    
    private static final long seriaVersionUID = 1L; // auto incremento en Java MySQL (AUTO_INCREMENT)  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marcas")

    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String marcas, boolean activo) {
        this.descripcion = marcas;
        this.activo = activo;
    }
    
}
