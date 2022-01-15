package com.miempresa.aplicacion.modelos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioFactura extends MongoRepository<Factura,Long> {
//    Factura findByNumeroFactura(String numeroFactura);
    
}
