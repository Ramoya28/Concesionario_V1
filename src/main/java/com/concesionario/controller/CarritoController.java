package com.concesionario.controller;

import com.concesionario.domain.Auto;
import com.concesionario.domain.Item;
import com.concesionario.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
//Para ver el carrito

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal",
                carritoTotalVenta);
        return "/carrito/listado";
    }
//Para Agregar un auto al carrito

    @GetMapping("/carrito/agregar/{idAuto}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Auto auto = autoService.getAuto(item
            );
            item2 = new Item(auto);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }
//Para mofificar un auto del carrito

    @GetMapping("/carrito/modificar/{idAuto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }
//Para eliminar un elemento del carrito

    @GetMapping("/carrito/eliminar/{idAuto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }
//Para actualizar un auto del carrito (cantidad)

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
//Para facturar los autos del carrito... no implementado...

    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}
