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


@Controller
@Slf4j
@RequestMapping("/buscar") //(buscar/listado)
public class BuscarController {

    @Autowired
    private AutoService AutoService;

    //metodos para (queries)
    @GetMapping("/listado")
    public String listado(Model model) {
        var autos = AutoService.getAuto(0); //Por ser long
        model.addAttribute("autos", autos);
        return "/buscar/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value = "marca") String marca, @RequestParam(value = "estilo") String estilo, @RequestParam(value = "combustible") String combustible, @RequestParam(value = "transmision") String transmision, @RequestParam(value = "provincia") String provincia, @RequestParam(value = "ano") int ano, @RequestParam(value = "precio") double precio, Model model) {
        var autos = AutoService.findByMarcaAndEstiloAndCombustibleAndTransmisionAndProvinciaAndAnoAndPrecio(marca, estilo, combustible, transmision, provincia, ano, precio);
        model.addAttribute("autos", autos);
        model.addAttribute("marca", marca);        
        model.addAttribute("estilo", estilo);
        model.addAttribute("combustible", combustible);
        model.addAttribute("transmision", transmision);
        model.addAttribute("provincia", provincia);
        model.addAttribute("ano", ano);
        model.addAttribute("precio", precio);
        return "/buscar/listado";
    }

}
