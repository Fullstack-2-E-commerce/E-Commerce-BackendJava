package cl.backend.javaSpring.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.pedido.model.DetallePedidoModel;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoModel, Long> {

    List<DetallePedidoModel> findByPedidoId(Long pedidoId);

}
