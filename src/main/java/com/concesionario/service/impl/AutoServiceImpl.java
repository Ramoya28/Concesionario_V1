package com.concesionario.service.impl;

import com.concesionario.domain.Auto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import com.concesionario.dao.AutoDao;
import com.concesionario.service.AutoService;

/**
 *
 * @author gabri
 */
@Service

public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao autoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Auto> getAuto(int idAuto){
        var lista=autoDao.findAll();
        return lista;        
    }

    @Override
    @Transactional(readOnly=true)
     public Auto getAuto(Auto autos){
         return autoDao.findById(autos.getIdAuto()).orElse(null);         
     }
     
    @Override
    @Transactional
    public void save(Auto autos) {
        autoDao.save(autos); //Guadar o modificar el id (auto)
    }

    @Override
    @Transactional

    public void delete(Auto autos) {
        autoDao.delete(autos); //Eliminar el id (autos)
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Auto> findByMarcaAndEstiloAndCombustibleAndTransmisionAndProvinciaAndAnoAndPrecio(String marca, String estilo, String combustible, String transmision, String provincia, int ano, double precio) {
        return autoDao.findByMarcaAndEstiloAndCombustibleAndTransmisionAndProvinciaAndAnoAndPrecio(marca, estilo, combustible, transmision, provincia, ano, precio);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Auto> metodoJPQL(@Param("marca") String marca, @Param("estilo") String estilo, 
            @Param("combustible") String combustible, @Param("transmision") String transmision, 
            @Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio){
     return autoDao.metodoJPQL(marca, estilo, combustible, transmision, provincia, ano, precio);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Auto> metodoNativo(@Param("marca") String marca, @Param("estilo") String estilo, 
            @Param("combustible") String combustible, @Param("transmision") String transmision, 
            @Param("provincia") String provincia, @Param("ano") int ano, @Param("precio") double precio){
       return autoDao.metodoNativo(marca, estilo, combustible, transmision, provincia, ano, precio);
    }
}
