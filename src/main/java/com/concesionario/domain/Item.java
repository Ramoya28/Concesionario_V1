package com.concesionario.domain;

import java.util.HashSet;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Auto {

    private int cantidad; //Almacenar la cantidad de items de un producto

    public Item() {
        
        
    }

    public Item(Auto auto) {
        super.setIdAuto(auto.getIdAuto());
        super.setMarca(auto.getMarca());
        super.setModelo(auto.getModelo());
        super.setEstilo(auto.getEstilo());
        super.setCombustible(auto.getCombustible());
        super.setTransmision(auto.getTransmision());
        super.setProvincia(auto.getProvincia());
        super.setAno(auto.getAno());
        super.setPrecio(auto.getPrecio());
        super.setRutaImagen(auto.getRutaImagen());
        super.setActivo(auto.isActivo());

    }


}
