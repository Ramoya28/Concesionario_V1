package com.concesionario.dao;

import com.concesionario.domain.Auto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gabri
 */
public interface AutoDao extends JpaRepository<Auto, Long>{        
    
    public List<Auto> findByMarcaAndEstiloAndCombustibleAndTransmisionAndProvinciaAndAnoAndPrecio(String marca, String estilo, String combustible, 
            String transmision, String provincia, int ano, double precio);
    
    @Query(value="SELECT a FROM Auto a WHERE (a.marca = :marca) AND " +
           "(a.estilo = :estilo) AND (a.combustible = :combustible) AND (a.transmision = :transmision) AND " +
           "(a.provincia = :provincia) AND (a.ano = :ano) AND (a.precio = :precio)")            
    public List<Auto> metodoJPQL(@Param("marca") String marca, @Param("estilo") String estilo, 
            @Param("combustible") String combustible, @Param("transmision") String transmision, 
            @Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio);
    
    @Query(nativeQuery = true, value = "SELECT * FROM Auto WHERE (Auto.marca = :marca) AND " +
           "(Auto.estilo = :estilo) AND (Auto.combustible = :combustible) AND (Auto.transmision = :transmision) AND " +
           "(Auto.provincia = :provincia) AND (Auto.ano = :ano) AND (Auto.precio = :precio)")        
    
    public List<Auto> metodoNativo(@Param("marca") String marca, @Param("estilo") String estilo, 
            @Param("combustible") String combustible, @Param("transmision") String transmision, 
            @Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio);
    
}