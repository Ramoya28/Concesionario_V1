/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.service.impl;


import com.concesionario.dao.SucursalDao;
import com.concesionario.domain.Sucursal;
import com.concesionario.service.SucursalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jorge Alfaro
 */

@Service
public class SucursalServiceImpl implements SucursalService{
    
    @Autowired
    private SucursalDao sucursalDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Sucursal> getSucursal(int idSucursal) {
        var lista=sucursalDao.findAll();
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)

    public Sucursal getSucursal(Sucursal sucursal) {

        return sucursalDao.findById(sucursal.getIdSucursal()).orElse(null);

    }

    @Override
    @Transactional
    
    public void save(Sucursal sucursal) {
        sucursalDao.save(sucursal); //Guadar o modificar el id (marcas)
    }
    
    @Override
    @Transactional
    
    public void delete(Sucursal sucursal){
        sucursalDao.delete(sucursal); //Eliminar el id (marcas)
    }
}
