package com.refaccionaria.refaccionariaapp.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping(path = "api/v1/producto")
public class productoController {

    private final productoService productoService;

    @Autowired
    public productoController(productoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<producto> getProductos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer categoria) {
        if(categoria != null) {
            return productoService.findByNombre(nombre);
        }
        else if(nombre != null){
            return productoService.findByCategoria(categoria);
        } else {
            return productoService.findAll();
        }
    }

    @PostMapping
    public ResponseEntity<producto> addProducto(@RequestBody producto producto) {
        producto createdProduct  = productoService.addProducto(producto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<producto> updateProducto(@RequestBody producto producto) {
        producto updatedProduct = productoService.updateProducto(producto);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Producto Borrado Correctamente", HttpStatus.OK);
    }
}

