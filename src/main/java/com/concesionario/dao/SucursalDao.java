/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.concesionario.dao;


import com.concesionario.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jorge Alfaro
 */
public interface SucursalDao extends JpaRepository<Sucursal, Long>{
    
}
