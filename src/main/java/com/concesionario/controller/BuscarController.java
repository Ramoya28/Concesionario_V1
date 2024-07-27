package com.concesionario.controller;

import com.concesionario.domain.Auto;
import com.concesionario.service.AutoService;
import com.concesionario.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/buscar") //(buscar/listado)
public class BuscarController {

    @Autowired
    private AutoService AutoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var autos = AutoService.getInformacion(0);
        model.addAttribute("autos", autos);
        return "/buscar/listado";
    }

    @GetMapping("/informacion")
    public String autoNuevo(Auto auto) {
        return "/buscar/informacion";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    //@GetMapping("/buscar")
    /*public String buscar(Model model) {
        var autos = AutoService.getAutos(false);
        model.addAttribute("autos", autos);
        model.addAttribute("totalAuto", autos.size());
        return "/buscar/listado";
    }*/
    @PostMapping("/informacion")
    public String informacion(@RequestParam("marca") String marca,
            @RequestParam("modelo") String modelo,
            @RequestParam("estilo") String estilo,
            @RequestParam("combustible") String combustible,
            @RequestParam("transmision") String transmision,
            @RequestParam("provincia") String provincia,
            @RequestParam("ano") int ano,
            @RequestParam("precio") double precio,
            Model model) {
        Auto auto = AutoService.validateAuto(marca, modelo, estilo, combustible, transmision, provincia, ano, precio);
        if (auto != null) {
            model.addAttribute("auto", auto);
            //return "redirect:/buscar/listado";
            return "/buscar/informacion";
        } else {
            model.addAttribute("error", "No se encuentran autos con las características filtradas");
            return "redirect:/buscar/informacion";
        }
    }
    
    @GetMapping("/informacionCardVehiculo")
    public String informacionCardVehiculo(@RequestParam("marca") String marca,
            @RequestParam("modelo") String modelo,
            @RequestParam("estilo") String estilo,
            @RequestParam("combustible") String combustible,
            @RequestParam("transmision") String transmision,
            @RequestParam("provincia") String provincia,
            @RequestParam("ano") int ano,
            @RequestParam("precio") double precio,
            Model model) {
        Auto auto = AutoService.validateAuto(marca, modelo, estilo, combustible, transmision, provincia, ano, precio);
        if (auto != null) {
            model.addAttribute("auto", auto);
            //return "redirect:/buscar/listado";
            return "/buscar/informacion";
        } else {
            model.addAttribute("error", "No se encuentran autos con las características filtradas");
            return "redirect:/buscar/informacion";
        }
    }

}
