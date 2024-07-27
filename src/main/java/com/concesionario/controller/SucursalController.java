/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.controller;

import com.concesionario.domain.Sucursal;
import com.concesionario.service.SucursalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jorge Alfaro
 */

@Controller
@Slf4j
@RequestMapping("/sucursal") //(buscar/listado)
public class SucursalController {
    
    @Autowired
    private SucursalService SucursalService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var sucursal = SucursalService.getSucursal(0);
        model.addAttribute("sucursal", sucursal);
        return "/sucursal/listado";
    }
    
    @GetMapping("/nuevo")
    public String sucursalNueva(Sucursal sucursal) {
        return "/sucursal/modifica";
    }
    
    @PostMapping("sucursal/guardarSucursal")
    public String guardarSucursal(Sucursal sucursal) {
        SucursalService.save(sucursal);
        return "redirect:/sucursal/listado";
    }
    
    @GetMapping("/eliminar/{idSucursal}")
    public String sucursalEliminar(Sucursal sucursal) {
        SucursalService.delete(sucursal);
        return "redirect:/sucursal/listado";
    }

    @GetMapping("/modificar/{idSucursal}")
    public String sucursalModificar(Sucursal sucursal, Model model) {
        sucursal = SucursalService.getSucursal(sucursal);
        model.addAttribute("sucursal", sucursal);
        return "/sucursal/modifica";
    }
    
    @GetMapping("/informacion/{idSucursal}")
    public String informacionSucursal(Sucursal sucursal, Model model) {
        sucursal = SucursalService.getSucursal(sucursal);
        model.addAttribute("sucursal", sucursal);
        return "/sucursal/informacion";
    }
    
}
