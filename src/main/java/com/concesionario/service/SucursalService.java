/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.concesionario.service;

import com.concesionario.domain.Sucursal;
import java.util.List;

/**
 *
 * @author Jorge Alfaro
 */
public interface SucursalService {
    
    public List<Sucursal> getSucursal(int idSucursal);
    
    
    public Sucursal getSucursal(Sucursal sucursal);
    

    public void save(Sucursal sucursal);
    

    public void delete(Sucursal sucursal);
}
