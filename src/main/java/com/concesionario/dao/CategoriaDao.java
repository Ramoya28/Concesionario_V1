package com.concesionario.dao;

import com.concesionario.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
