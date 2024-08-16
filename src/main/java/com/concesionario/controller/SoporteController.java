/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.controller;

import com.concesionario.domain.Soporte;
import com.concesionario.service.SoporteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */

@Controller
@Slf4j
@RequestMapping("/soporte") 

public class SoporteController {
     @Autowired
    private SoporteService soporteService;
     
     @GetMapping("/listado")
    public String inicio(Model model) {
        var soporte = soporteService.getSoporte(false);
        model.addAttribute("soportes", soporte);
        model.addAttribute("totalSoportes", soporte.size());
        return "/soporte/listado";
    }
     
     
     
     @GetMapping("/nuevo")
     public String soporteNuevo(Soporte soporte){
         return "/soporte/modifica";
     }
     
     @PostMapping("/guardar")
     public String soporteGuardar(Soporte soporte){
         soporteService.save(soporte);
         return "redirect:/soporte/listado";
     }
}
