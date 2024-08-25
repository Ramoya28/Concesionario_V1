package com.concesionario.service.impl;

import com.concesionario.dao.AutoDao;
import com.concesionario.dao.FacturaDao;
import com.concesionario.dao.VentaDao;
import com.concesionario.domain.Auto;
import com.concesionario.domain.Factura;
import com.concesionario.domain.Item;
import com.concesionario.domain.Usuario;
import com.concesionario.domain.Venta;
import com.concesionario.service.ItemService;
import com.concesionario.service.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }
//Se usa en el addCarrito... agrega un elemento

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {

//Busca si ya existe el producto en el carrito
            if (Objects.equals(i.getIdAuto(),item.getIdAuto())) {

//Valida si aún puede colocar un item adicion al - segun existencias 
//Incrementa en 1 la cantidad de elementos 

                    i.setCantidad(i.getCantidad() + 1);
                
            }
        }
        if (!existe) {//Si no está el producto en el carritose agrega cantidad = 1.
            item.setCantidad(1);
            listaItems.add(item);
        }
    }
//Se usa para eliminar un producto del carrito

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdAuto(), item.getIdAuto())) {

                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }
//Se obtiene la información de un producto del carrito...para modificarlo

    @Override

    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAuto(), item.getIdAuto())) {

                return i;
            }
        }
        return null;
    }
//Se usa en la página para actualizar la cantidad de productos

    @Override

    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAuto(), item.getIdAuto())) {

                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }
    @Autowired
    private UsuarioService uuarioService;
    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private AutoDao autoDao;

    @Override
    public void facturar() {
        System.out.println("Facturando");
//Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        if (username.isBlank()) {
            return;
        }
        Usuario uuario = uuarioService.getUsuarioPorUsername(username);
        if (uuario == null) {
            return;
        }
        Factura factura = new Factura(uuario.getIdUsuario());
        factura = facturaDao.save(factura);
        double total = 0;
        for (Item i : listaItems) {
            System.out.println("Modelo: " + i.getModelo()
                    +"Marca: " + i.getMarca()
                    + "Cantidad: " + i.getCantidad()
                    + "Total: " + i.getPrecio() * i.getCantidad()
            );
            Venta venta = new Venta(factura.getIdFactura(),
                    i.getIdAuto(), i.getPrecio(), i.getCantidad());
            ventaDao.save(venta);

            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
    }
}
