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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private List<Item> listaItems = new ArrayList<>();

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private AutoDao autoDao;

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAuto(), item.getIdAuto())) {
                i.setCantidad(i.getCantidad() + 1);
                existe = true;
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        listaItems.removeIf(i -> Objects.equals(i.getIdAuto(), item.getIdAuto()));
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAuto(), item.getIdAuto())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAuto(), item.getIdAuto())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturar() {
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
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
        if (usuario == null) {
            return;
        }
        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaDao.save(factura);
        double total = 0;
        for (Item i : listaItems) {
            Venta venta = new Venta(factura.getIdFactura(), i.getIdAuto(), i.getPrecio(), i.getCantidad());
            ventaDao.save(venta);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
    }
}
