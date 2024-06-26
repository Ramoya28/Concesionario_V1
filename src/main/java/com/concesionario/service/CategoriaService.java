package com.concesionario.service;

import com.concesionario.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
}
