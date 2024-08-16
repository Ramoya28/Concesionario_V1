/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.concesionario.service;

import com.concesionario.domain.Contacto;
import java.util.List;

/**
 *
 * @author user
 */
public interface ContactoService {
    
    public List<Contacto> getContacto(boolean activos);
    public void save(Contacto contacto);
}
