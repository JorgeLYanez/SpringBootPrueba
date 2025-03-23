package com.refaccionaria.refaccionariaapp.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class productoService {
    private final  productoRepository productoRepository;

    @Autowired
    public productoService(productoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<producto> findAll() {
        return productoRepository.findAll();
    }

    public List<producto> findByCategoria(Integer categoria) {
        return productoRepository.findAll().stream()
                .filter(producto -> categoria.equals(producto.getCategoria_id()))
                .collect(Collectors.toList());
    }

    public List<producto> findByNombre(String nombre) {
        return productoRepository.findAll().stream()
                .filter(producto -> nombre.toLowerCase().contains(producto.getNombre().toLowerCase()))
                .collect(Collectors.toList());
    }

    //Products out of stock
    public List<producto> findOutOfStockProducts() {
        return productoRepository.findByStock(0); // Buscar productos sin stock
    }

    //Add Product
    public producto addProducto(producto producto) {
        return productoRepository.save(producto);
    }

    //Edit Product
    public producto updateProducto(producto updatedproducto) {
        Optional<producto> existingProduct = productoRepository.findById(updatedproducto.getId());
        if (existingProduct.isPresent()) {
            updatedproducto.setNombre(existingProduct.get().getNombre());
            updatedproducto.setStock(existingProduct.get().getStock());
            updatedproducto.setDescripcion(existingProduct.get().getDescripcion());
            updatedproducto.setCategoria_id(existingProduct.get().getCategoria_id());
            updatedproducto.setPrecio(existingProduct.get().getPrecio());
            productoRepository.save(updatedproducto);
            return updatedproducto;
        }
       return null;
    }


    //Delete Product
    public void  deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
