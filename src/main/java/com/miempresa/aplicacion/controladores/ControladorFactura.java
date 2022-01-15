package com.miempresa.aplicacion.controladores;

import com.miempresa.aplicacion.dtos.FacturaDto;
import com.miempresa.aplicacion.exceptions.ProductNotFoundException;
import com.miempresa.aplicacion.modelos.RepositorioFactura;
import com.miempresa.aplicacion.modelos.Factura;
import com.miempresa.aplicacion.modelos.Producto;
import com.miempresa.aplicacion.modelos.RepositorioProducto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(
        @Autowired))
@RequestMapping("/facturas")
public class ControladorFactura {

    private final RepositorioFactura repositorioFactura;
    private final RepositorioProducto repositorioProducto;

    @GetMapping(path = "/all") //path del controlador
    public ArrayList<Factura> getTodasLasFacturas(Model model) {
        Iterable<Factura> facturas = repositorioFactura.findAll();
        return (ArrayList<Factura>) facturas;
    }

    @GetMapping(path = "/{idFactura}") //path del controlador
    public Factura getFacturaByNumero(@PathVariable Long idFactura) {
        Factura factura = repositorioFactura.findById(idFactura)
                .orElseThrow(() -> new ProductNotFoundException(
                "No se encontró una factura con el código: " + idFactura));;
        return factura;
    }

//
    @PostMapping(path = "/crear")
    public Factura crearFactura(@RequestBody FacturaDto facturaDto) {
//        if (repositorioFactura.findByNumeroFactura(facturaDto.getNumeroFactura()) == null) {
        List<Producto> productos = (List<Producto>) repositorioProducto.findAllById(facturaDto.getCodigosProducto());
//            Vendedor vendedor = repositorioVendedor.findByCodVendedor(facturaDto.getCodigoVendedor());
//            if (producto == null || vendedor == null) {
//                return new RedirectView("/facturasA");
//            }
        Factura factura = new Factura();
        factura.setIdFactura(facturaDto.getIdFactura());
        factura.setProductos(productos);
        factura.setUsername(facturaDto.getUsername());
        factura.setFechaVenta(new Date());
        Double total = 0.0;
        for (Producto p : productos) {
            long repetidos = facturaDto.getCodigosProducto().stream()
                    .filter(r -> r.equals(p.getCodProducto()))
                    .count();
            if (repetidos > 1) {
                total = (repetidos * p.getPrecioProducto()) + total;
            } else {
                total = total + p.getPrecioProducto();
            }
        }
        factura.setValorFactura(total);
        Factura facturaGuardada = repositorioFactura.save(factura);
//            if (facturaDto.getNumeroFactura() == null
//                    || facturaDto.getNumeroFactura() == ""
//                    || facturaDto.getCodigoVendedor() == ""
//                    || facturaDto.getValorFactura() == 0
//                    || facturaDto.getCodigoProducto() == ""
//                    || facturaDto.getCodigoProducto() == null
//                    || facturaDto.getCodigoVendedor() == null
//                    || facturaDto.getValorFactura() == null) {
//                return new RedirectView("/crear/factura/", true);
//            } else {
//                Factura facturaGuardada = repositorioFactura.save(factura);
//                if (facturaGuardada == null) {
//                    return new RedirectView("/crear/factura/", true);
//                }
//                return new RedirectView("/facturas/" + facturaGuardada.getNumeroFactura(), true);
//            }
//        } else {
//            return new RedirectView("/crear/factura/", true);
//        }
        return facturaGuardada;
    }
//
//    @GetMapping("/facturas/Borrar") //path del controlador
//    public RedirectView findFacturab(Model model) {
//        model.addAttribute("factura", new FacturaDto());
//        return new RedirectView("/facturasA", true);
//    }
//
//    @PostMapping("/facturas/Borrar") //path del controlador
//    public String borrarFacturaV(@ModelAttribute FacturaDto factura, Model model) {
//        Factura factura2 = repositorioFactura.findByNumeroFactura(factura.getNumeroFactura());
//
//        if (factura2 == null) {
//            return "redirect:/facturas/Borrar";
//        } else {
//            repositorioFactura.delete(factura2);
//            return "redirect:/facturas";
//        }
//    }
//
//    @GetMapping("/facturas/Borrar/{numeroFactura}") //path del controlador
//    public String borrarFactura(@PathVariable String numeroFactura, Model model) {
//        Factura factura = repositorioFactura.findByNumeroFactura(numeroFactura);
//        System.out.println(factura);
//        if (factura == null) {
//            return "vistaFormularioAdminFacturas";
//        } else {
//            repositorioFactura.delete(factura);
//            return "redirect:/facturas";
//        }
//    }
//

    @PatchMapping("/editar/{idFactura}") //path del controlador
    public Factura findFacturaA(@PathVariable Long idFactura,
            @RequestBody FacturaDto factura) {
        Factura facturaModificada = getFacturaByNumero(idFactura);
        ArrayList<String> cantidadProductos = factura.getCodigosProducto();

        List<Producto> productos = (List<Producto>) repositorioProducto.findAllById(factura.getCodigosProducto());
//        facturaModificada.setIdFactura(factura.getIdFactura());
        facturaModificada.setProductos(productos);
        facturaModificada.setUsername(factura.getUsername());
        facturaModificada.setFechaVenta(new Date());
        Double total = 0.0;
        for (Producto p : productos) {
            long repetidos = cantidadProductos.stream()
                    .filter(r -> r.equals(p.getCodProducto()))
                    .count();
            if (repetidos > 1) {
                total = (repetidos * p.getPrecioProducto()) + total;
            } else {
                total = total + p.getPrecioProducto();
            }
        }
        facturaModificada.setValorFactura(total);
        Factura facturaGuardada = repositorioFactura.save(facturaModificada);
        return facturaGuardada;
    }
//
//    @PostMapping("/facturas/Modificar") //path del controlador
//    public String actualizarFactura(@ModelAttribute FacturaDto facturaDto, Model model) {
//        Factura factura = repositorioFactura.findByNumeroFactura(facturaDto.getNumeroFactura());
//
//        if (factura == null) {
//            System.out.println("Factura no Existe");
//        } else {
//            Producto producto = repositorioProducto.findByCodProducto(facturaDto.getCodigoProducto());
//            if (producto != null) {
//                System.out.println("Producto Existe");
//                //si el producto existe en la base de datos se actualiza la factura
//                factura.setProducto(producto);
//                System.out.println(facturaDto);
//                if (facturaDto.getValorFactura() == null) {
//                    factura.setValorFactura((float) 0);
//                } else {
//                    factura.setValorFactura(facturaDto.getValorFactura());
//                }
//                //se guarda la factura en la base de datos
//                repositorioFactura.save(factura);
//            } else {
//                System.out.println("Producto no Existe");
//            }
//            return "redirect:/facturas/" + factura.getNumeroFactura();
//        }
//        return "redirect:/facturas/";
//    }
//
////Controlador vistas Vendedor
//    @GetMapping("/facturasV") //path del controlador
//    public String getTodasLasFacturasV(Model model) {
//        Iterable<Factura> facturas = repositorioFactura.findAll();
//        model.addAttribute("factura", new FacturaDto());
//        model.addAttribute("facturas", facturas);
//        return "vistaFacturaV";
//    }
//
//    @GetMapping("/crear/facturaV") //path del controlador
//    public String crearFacturaV(Model model) {
//        model.addAttribute("factura", new FacturaDto());
//        return "vistaFacturaV";
//    }
//
//    @PostMapping("/crear/facturaV")
//    public RedirectView procesarProductoV(@ModelAttribute FacturaDto facturaDto) {
//        if (repositorioFactura.findByNumeroFactura(facturaDto.getNumeroFactura()) == null) {
//            Producto producto = repositorioProducto.findByCodProducto(facturaDto.getCodigoProducto());
//            Vendedor vendedor = repositorioVendedor.findByCodVendedor(facturaDto.getCodigoVendedor());
//            if (producto == null || vendedor == null) {
//                return new RedirectView("/facturasV");
//            }
//            Factura factura = new Factura();
//            factura.setNumeroFactura(facturaDto.getNumeroFactura());
//            factura.setProducto(producto);
//            factura.setVendedor(vendedor);
//            factura.setFechaVenta(facturaDto.getFechaVenta());
//            factura.setValorFactura(facturaDto.getValorFactura());
//
//            if (facturaDto.getNumeroFactura() == null
//                    || facturaDto.getNumeroFactura() == ""
//                    || facturaDto.getCodigoVendedor() == ""
//                    || facturaDto.getValorFactura() == 0
//                    || facturaDto.getCodigoProducto() == ""
//                    || facturaDto.getCodigoProducto() == null
//                    || facturaDto.getCodigoVendedor() == null
//                    || facturaDto.getValorFactura() == null) {
//                return new RedirectView("/crear/facturaV", true);
//            } else {
//                Factura facturaGuardada = repositorioFactura.save(factura);
//                if (facturaGuardada == null) {
//                    return new RedirectView("/crear/facturaV", true);
//                }
//                return new RedirectView("/facturas/" + facturaGuardada.getNumeroFactura(), true);
//            }
//        } else {
//            return new RedirectView("/crear/facturaV", true);
//        }
//
//    }
//
//    @GetMapping("/consultar/facturaV") //path del controlador
//    public RedirectView findFacturaV(Model model) {
//        model.addAttribute("factura", new FacturaDto());
//        return new RedirectView("/facturasV");
//    }
//
//    @PostMapping("/consultar/facturaV") //path del controlador
//    public String procesarFacturaV(@ModelAttribute FacturaDto facturaDto, Model model) {
//
//        boolean flag = false;
//        if (facturaDto.getCodigoVendedor() != null && facturaDto.getCodigoVendedor() != "") {
//
//            Vendedor vendedor = repositorioVendedor.findByCodVendedor(facturaDto.getCodigoVendedor());
//
//            if (vendedor != null) {
//
//                Iterable<Factura> facturas = repositorioFactura.findAll();
//                List<Factura> facturas2 = new ArrayList<>();
//
//                for (Factura l : facturas) {
//
//                    if (l.getVendedor().getCodVendedor().equals(vendedor.getCodVendedor())) {
//                        flag = true;
//                        facturas2.add(l);
//                    }
//                }
//                if (flag == false) {
//                    return "redirect:/consultar/facturaV";
//                }
//                model.addAttribute("facturas", facturas2);
//                return "vistaFactura";
//            } else {
//
//                return "redirect:/facturas";
//            }
//        } else {
//
//            System.out.println("Numero Factura");
//            Factura factura = repositorioFactura.findByNumeroFactura(facturaDto.getNumeroFactura());
//            if (factura != null) {
//                return "redirect:/facturas/" + factura.getNumeroFactura();
//            } else {
//                return "redirect:/facturasV";
//            }
//        }
//
//    }

}
