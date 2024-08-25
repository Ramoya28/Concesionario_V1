package com.concesionario.controller;

import com.concesionario.domain.Auto;
import com.concesionario.domain.Item;
import com.concesionario.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.concesionario.service.AutoService;

@Controller
public class CarritoController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private AutoService autoService;

    @GetMapping("/")
    private String listado(Model model) {
        var autos = autoService.getAuto(0);
        model.addAttribute("autos", autos);
        return "/index";
    }

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }

    @GetMapping("/carrito/agregar/{idAuto}")
    public String agregarItem(@PathVariable("idAuto") Long idAuto, Model model) {
        Item item = itemService.get(new Item(new Auto(idAuto)));
        if (item == null) {
            Auto auto = autoService.getAuto(idAuto);
            item = new Item(auto);
            itemService.save(item);
        } else {
            item.setCantidad(item.getCantidad() + 1);
            itemService.save(item);
        }
        return "redirect:/carrito/listado";
    }

    @GetMapping("/carrito/modificar/{idAuto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    @GetMapping("/carrito/eliminar/{idAuto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}
