package com.spring.springmarket.persistence;

import com.spring.springmarket.persistence.crud.ProductoCrudRepository;
import com.spring.springmarket.persistence.entity.Producto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/*
@Component, es una generalizacion de este tipo de antoaciones estamos indicando que es un componente de
spring, pero con Repository indicamos que tipo de componente es.
 */
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}

