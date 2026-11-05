package cl.backend.javaSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.model.DetallePedidoModel;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoModel, Long> {

    List<DetallePedidoModel> findByPedidoId(Long pedidoId);

}
