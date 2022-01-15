package com.miempresa.aplicacion.dtos;


import java.util.ArrayList;
import lombok.Data;


@Data
public class FacturaDto {
    private Long idFactura;
    private ArrayList<String> codigosProducto;
    private String username;
    
}
