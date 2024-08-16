/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.concesionario.service;

import com.concesionario.domain.Soporte;
import java.util.List;

/**
 *
 * @author user
 */
public interface SoporteService {
    
    public List<Soporte> getSoporte(boolean activos);
    public void save(Soporte soporte);
}
