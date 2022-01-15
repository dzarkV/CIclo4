package com.miempresa.aplicacion.modelos;

import java.util.Date;
import java.util.List;
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
public class Factura {
    
    @Getter
    @Setter
    @Id 
    private Long idFactura;
    @Getter    
    @Setter 
    private List<Producto> productos;
    @Getter 
    @Setter 
    private Date fechaVenta;   
    @Getter
    @Setter 
    private String username;
    @Getter
    @Setter 
    private Double valorFactura;
}
