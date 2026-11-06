package cl.backend.javaSpring.producto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.producto.model.ProductosModel;

public interface ProductosRepository extends JpaRepository<ProductosModel, Long> {

    List<ProductosModel> findByCategoria(String categoria);

    List<ProductosModel> findByDestacadoTrue();

    List<ProductosModel> findByStockLessThanEqual(Integer stockCritico);

}
