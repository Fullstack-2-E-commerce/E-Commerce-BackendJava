package cl.backend.javaSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.model.ProductosModel;

public interface ProductosRepository extends JpaRepository<ProductosModel, Long>{

    List<ProductosModel> findByCategoria(String categoria);
    List<ProductosModel> findByDestacadoTrue();
    List<ProductosModel> findByStockLessThanEqual(Integer stockCritico);

}
