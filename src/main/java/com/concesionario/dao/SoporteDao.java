/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.concesionario.dao;

import com.concesionario.domain.Soporte;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author user
 */
public interface SoporteDao extends JpaRepository<Soporte, Long>{
    
}
