package com.miempresa.aplicacion.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Entity
@Document
public class Producto {

    @Getter
    @Setter
    @Id
    private String codProducto;

    @Getter
    @Setter
    private String nombreProducto;

    @Getter
    @Setter
    private String descripcionProducto;

    @Getter
    @Setter
    private Double precioProducto;

    @Getter
    @Setter
    private Boolean isActive;
}
