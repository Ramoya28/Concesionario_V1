package com.concesionario.dao;

import com.concesionario.domain.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gabri
 */
public interface AutoDao extends JpaRepository<Auto, Long>{        
    
     @Query("SELECT a FROM Auto a WHERE " +
           "(a.marca = :marca) AND " +
           "(a.modelo = :modelo) AND " +
           "(a.estilo = :estilo) AND " +
           "(a.combustible = :combustible) AND " +
           "(a.transmision = :transmision) AND " +
           "(a.provincia = :provincia) AND " +
           "(a.ano = :ano) AND " +
           "(a.precio = :precio)")
    Auto findByAuto(@Param("marca") String marca, @Param("modelo") String modelo, @Param("estilo") String estilo, 
            @Param("combustible") String combustible, @Param("transmision") String transmision, 
            @Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio);
    
}