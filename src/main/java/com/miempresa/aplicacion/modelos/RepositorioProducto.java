package com.miempresa.aplicacion.modelos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends MongoRepository<Producto,String> {
    Producto findByCodProducto(String codProducto);
}
