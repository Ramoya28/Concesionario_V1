package com.concesionario.service.impl;

import com.concesionario.dao.CategoriaDao;
import com.concesionario.domain.Categoria;
import com.concesionario.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)

    public Categoria getCategoria(Categoria marcas) {

        return categoriaDao.findById(marcas.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    
    public void save(Categoria marcas) {
        categoriaDao.save(marcas); //Guadar o modificar el id (marcas)
    }
    
    @Override
    @Transactional
    
    public void delete(Categoria marcas){
        categoriaDao.delete(marcas); //Eliminar el id (marcas)
    }
    
}
