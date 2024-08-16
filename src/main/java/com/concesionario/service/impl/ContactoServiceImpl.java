/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.service.impl;


import com.concesionario.dao.ContactoDao;
import com.concesionario.domain.Contacto;
import com.concesionario.service.ContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class ContactoServiceImpl implements ContactoService{
    
    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getContacto(boolean activos) {
       var lista = contactoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
}
