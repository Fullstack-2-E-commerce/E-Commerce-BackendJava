package cl.backend.javaSpring.pedido.dto;

import java.time.LocalDateTime;
import java.util.List;

import cl.backend.javaSpring.pedido.model.EstadoPedidoEnum;
import cl.backend.javaSpring.pedido.model.TipoEntregaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private Long usuarioId;
    private String nombreUsuario;
    private LocalDateTime fechaPedido;
    private EstadoPedidoEnum estado;
    private TipoEntregaEnum tipoEntrega;
    private Integer numeroMesa;
    private Double total;
    private String observaciones;
    private List<DetallePedidoResponseDTO> items;

}
