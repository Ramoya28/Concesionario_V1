package com.concesionario.service;

import com.concesionario.domain.Auto;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gabri
 */
public interface AutoService {

    public List<Auto> getAuto(int idAuto);

    public Auto getAuto(Auto autos);
    
    public void save(Auto autos);

    public void delete(Auto autos);

    public List<Auto> findByMarcaAndEstiloAndCombustibleAndTransmisionAndProvinciaAndAnoAndPrecio(String marca, String estilo, String combustible, String transmision, String provincia, int ano, double precio);

    public List<Auto> metodoJPQL(@Param("marca") String marca, @Param("estilo") String estilo,@Param("combustible") String combustible, @Param("transmision") String transmision,@Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio);

    public List<Auto> metodoNativo(@Param("marca") String marca, @Param("estilo") String estilo,@Param("combustible") String combustible, @Param("transmision") String transmision,@Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio);

}
