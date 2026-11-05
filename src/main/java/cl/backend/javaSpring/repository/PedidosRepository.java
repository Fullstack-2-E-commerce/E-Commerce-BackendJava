package cl.backend.javaSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.model.EstadoPedidoEnum;
import cl.backend.javaSpring.model.PedidosModel;
import cl.backend.javaSpring.model.UsuariosModel;

public interface PedidosRepository extends JpaRepository <PedidosModel, Long> {

    List<PedidosModel> findByEstado(EstadoPedidoEnum estado);
    List<PedidosModel> findByUsuario(UsuariosModel usuario);

}
