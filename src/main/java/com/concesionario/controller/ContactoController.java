/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concesionario.controller;

import com.concesionario.domain.Contacto;
import com.concesionario.service.ContactoService;
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
@RequestMapping("/contacto") 

public class ContactoController {
     @Autowired
    private ContactoService contactoService;
     
     @GetMapping("/listado")
    public String inicio(Model model) {
        var contacto = contactoService.getContacto(false);
        model.addAttribute("contactos", contacto);
        model.addAttribute("totalContactos", contacto.size());
        return "/contacto/listado";
    }
     
     
     
     @GetMapping("/nuevo")
     public String contactoNuevo(Contacto contacto){
         return "/contacto/modifica";
     }
     
     @PostMapping("/guardar")
     public String contactoGuardar(Contacto contacto){
         contactoService.save(contacto);
         return "redirect:/contacto/listado";
     }
}
