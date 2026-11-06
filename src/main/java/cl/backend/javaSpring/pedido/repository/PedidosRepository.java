package cl.backend.javaSpring.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.pedido.model.EstadoPedidoEnum;
import cl.backend.javaSpring.pedido.model.PedidosModel;
import cl.backend.javaSpring.usuario.model.UsuariosModel;

public interface PedidosRepository extends JpaRepository<PedidosModel, Long> {

    List<PedidosModel> findByEstado(EstadoPedidoEnum estado);

    List<PedidosModel> findByUsuario(UsuariosModel usuario);

}
