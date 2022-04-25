package com.spring.springmarket.persistence.crud;

import com.spring.springmarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /*Si tenemos la anotacion no haria falta que utilicemos query methods,
    podriamos llamar el metodo de otra forma.
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
