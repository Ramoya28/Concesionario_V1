package com.concesionario.service.impl;

import com.concesionario.domain.Auto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public List<Auto> getInformacion(int idAuto){
        //var lista = autoDao.findAll();
        //return lista;
        return autoDao.findAll();
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
    public Auto validateAuto (String marca, String modelo, String estilo, String combustible, String transmision, String provincia, int ano, double precio) {
        return autoDao.findByAuto(marca, modelo, estilo, combustible, transmision, provincia, ano, precio);
    }
}
