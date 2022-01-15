package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.exceptions.ProductNotFoundException;
import com.miempresa.aplicacion.modelos.Producto;
import com.miempresa.aplicacion.modelos.RepositorioProducto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author dzark
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(
        @Autowired))
@RequestMapping("/productos") //path del controlador
public class ControladorProducto {

    private final RepositorioProducto repositorioProducto;

    /**
     * Método para obtener un producto por Id
     *
     * @param codigoProducto
     * @return
     */
    @GetMapping(path = "/{codigoProducto}")
    public Producto getProductoById(@PathVariable String codigoProducto) {
        Producto productoEncontrado = repositorioProducto.findById(codigoProducto)
                .orElseThrow(() -> new ProductNotFoundException(
                "No se encontró un producto con el código: " + codigoProducto));
        if (productoEncontrado.getIsActive().equals(false)) {
            throw new ProductNotFoundException("El producto con código "
                    + codigoProducto + " fue borrado anteriormente");
        }
        return productoEncontrado;

    }

    /**
     * Método para obtener todos los productos registrados
     *
     * 
     * @return
     */
    @GetMapping(path = "/all") //path del controlador
    public ArrayList<Producto> AllProductos() {
        List<Producto> productosEncontrados = repositorioProducto.findAll();
        ArrayList<Producto> productosActivos = new ArrayList<>(); 
        productosEncontrados.stream().filter(p -> (!p.getIsActive().equals(false)))
                .forEachOrdered(p -> {productosActivos.add(p);
        });
        return productosActivos;
    }

    /**
     * Método para crear un producto y guardarlo
     *
     * @param producto
     * @return
     */
    @PostMapping(path = "/crear")
    public Producto crearProducto(@RequestBody Producto producto
    ) {
        producto.setIsActive(true);
        Producto productoGuardado = repositorioProducto.save(producto);
        return productoGuardado;

    }

    /**
     * Método para editar y actualizar un producto
     *
     * @param codProducto
     * @param producto
     * @return
     */
    @PatchMapping(path = "/editar/{codProducto}")
    public Producto actualizarProducto(@PathVariable String codProducto,
            @RequestBody Producto producto) {
        Producto productoElegido = repositorioProducto.findByCodProducto(codProducto);
        productoElegido.setNombreProducto(producto.getNombreProducto());
        productoElegido.setDescripcionProducto(producto.getDescripcionProducto());
        productoElegido.setPrecioProducto(producto.getPrecioProducto());
        productoElegido.setIsActive(producto.getIsActive());
        return crearProducto(productoElegido);
    }

    /**
     * Método para eliminar producto
     *
     * @param codProducto
     * @return
     */
    @DeleteMapping(path = "/eliminar/{codProducto}")
    public String eliminarProducto(@PathVariable String codProducto) {
        Producto productoElegido = repositorioProducto.findByCodProducto(codProducto);
        if (productoElegido == null) {
            return "No se pudo eliminar el producto con código: " + codProducto
                    + ". El producto no existe.";
        } else {
            productoElegido.setIsActive(false);
            actualizarProducto(codProducto, productoElegido);
//            repositorioProducto.deleteById(codProducto);
            return "Se eliminó el producto con código: " + codProducto;
        }
    }
}
