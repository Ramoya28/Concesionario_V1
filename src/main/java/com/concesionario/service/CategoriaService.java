package com.concesionario.service;

import com.concesionario.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    // Se obtiene un Categoria, a partir del id de un marcas
    public Categoria getCategoria(Categoria marcas);
    
    // Se inserta un nuevo marcas si el id del marcas esta vacío
    // Se actualiza un marcas si el id del marcas NO esta vacío
    public void save(Categoria marcas);
    
    // Se elimina el marcas que tiene el id pasado por parámetro
    public void delete(Categoria marcas);
    
}
