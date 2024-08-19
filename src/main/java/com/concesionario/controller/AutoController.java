package com.concesionario.controller;

import com.concesionario.domain.Auto;
import com.concesionario.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var autos = autoService.getAuto(0);
        model.addAttribute("auto", autos);
        model.addAttribute("totalAutos", autos.size());
        return "/auto/listado";
    }

    @GetMapping("/nuevo")
    public String autoNuevo(Model model) {
        model.addAttribute("auto", new Auto());
        return "/auto/modifica";
    }

    @PostMapping("/guardar")
    public String guardarAuto(@ModelAttribute("auto") Auto auto) {
        autoService.save(auto);
        return "redirect:/auto/listado";
    }

    @GetMapping("/modificar/{idAuto}")
    public String modificarAuto(@PathVariable("idAuto") Long idAuto, Model model) {
        Auto auto = autoService.getAuto(idAuto);
        model.addAttribute("auto", auto);
        return "/auto/modifica";
    }

    @GetMapping("/eliminar/{idAuto}")
    public String eliminarAuto(@PathVariable("idAuto") Long idAuto) {
        Auto auto = new Auto();
        auto.setIdAuto(idAuto);
        autoService.delete(auto);
        return "redirect:/auto/listado";
    }

    @GetMapping("/informacion/{idAuto}")
    public String informacionAuto(@PathVariable("idAuto") Long idAuto, Model model) {
        Auto auto = autoService.getAuto(idAuto);
        if (auto == null) {
            return "redirect:/auto/listado";
        }
        model.addAttribute("auto", auto);
        return "/auto/informacion";
    }

}
