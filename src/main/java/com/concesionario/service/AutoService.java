package com.concesionario.service;

import com.concesionario.domain.Auto;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface AutoService {
    
    //public List<Auto> getAutos(boolean activos);
    //obtener toda la informacion del auto
    public List<Auto> getInformacion(int idAuto);
    
    // Se obtiene un Auto, a partir del id de un auto
    //public Auto getAuto(Auto autos);
    
    // Se inserta un nuevo marcas si el id del marcas esta vacío
    // Se actualiza un marcas si el id del marcas NO esta vacío
    public void save(Auto autos);
    
    // Se elimina el marcas que tiene el id pasado por parámetro
    public void delete(Auto autos);
    
    Auto validateAuto(String marca, String modelo, String estilo, String combustible, String transmision, String provincia, int ano, double precio);
    

}
