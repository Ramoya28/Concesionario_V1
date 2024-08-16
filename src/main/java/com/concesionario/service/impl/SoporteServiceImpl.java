/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.service.impl;


import com.concesionario.dao.SoporteDao;
import com.concesionario.domain.Soporte;
import com.concesionario.service.SoporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class SoporteServiceImpl implements SoporteService{
    
    @Autowired
    private SoporteDao soporteDao;

    @Override
    @Transactional
    public void save(Soporte soporte) {
        soporteDao.save(soporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Soporte> getSoporte(boolean activos) {
       var lista = soporteDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
}
