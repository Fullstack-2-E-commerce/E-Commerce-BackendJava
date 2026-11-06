package cl.backend.javaSpring.pedido.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import cl.backend.javaSpring.pedido.dto.CrearPedidoRequestDTO;
import cl.backend.javaSpring.pedido.dto.DetallePedidoResponseDTO;
import cl.backend.javaSpring.pedido.dto.ItemPedidoRequestDTO;
import cl.backend.javaSpring.pedido.dto.PedidoResponseDTO;
import cl.backend.javaSpring.pedido.model.DetallePedidoModel;
import cl.backend.javaSpring.pedido.model.EstadoPedidoEnum;
import cl.backend.javaSpring.pedido.model.PedidosModel;
import cl.backend.javaSpring.producto.model.ProductosModel;
import cl.backend.javaSpring.usuario.model.UsuariosModel;

@Component 
public class PedidoMapper {

    public PedidosModel toEntity(CrearPedidoRequestDTO dto, UsuariosModel usuario) {
        
        PedidosModel pedido = new PedidosModel();
        pedido.setUsuario(usuario);
        pedido.setFechaPedido(LocalDateTime.now());
        pedido.setEstado(EstadoPedidoEnum.PENDIENTE);
        pedido.setTipoEntrega(dto.getTipoEntrega());
        pedido.setNumeroMesa(dto.getNumeroMesa());
        pedido.setObservaciones(dto.getObservaciones());
        pedido.setTotal(0.0);
        return pedido;

    }

    public DetallePedidoModel toDetailEntity(ItemPedidoRequestDTO dto, PedidosModel pedido, ProductosModel producto){
        DetallePedidoModel detalle = new DetallePedidoModel();
        detalle.setPedido(pedido);
        detalle.setProducto(producto);
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.setSubtotal(producto.getPrecio() * dto.getCantidad());
        detalle.setNotasEspeciales(dto.getNotasEspeciales());
        return detalle;
    }

    public PedidoResponseDTO toResponseDTO(PedidosModel pedido, List<DetallePedidoModel> detalles) {
        List<DetallePedidoResponseDTO> itemDTOs = detalles.stream()
                .map(this::toDetailResponseDTO)
                .toList();

        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getUsuario().getId(),
            pedido.getUsuario().getNombre() + " " + pedido.getUsuario().getApellidos(),
            pedido.getFechaPedido(),
            pedido.getEstado(),
            pedido.getTipoEntrega(),
            pedido.getNumeroMesa(),
            pedido.getTotal(),
            pedido.getObservaciones(),
            itemDTOs
        );
    }

    public DetallePedidoResponseDTO toDetailResponseDTO(DetallePedidoModel detalle) {
        return new DetallePedidoResponseDTO(
            detalle.getId(),
            detalle.getProducto().getId(),
            detalle.getProducto().getNombreProducto(),
            detalle.getCantidad(),
            detalle.getPrecioUnitario(),
            detalle.getSubtotal(),
            detalle.getNotasEspeciales()
        );
    }

}
