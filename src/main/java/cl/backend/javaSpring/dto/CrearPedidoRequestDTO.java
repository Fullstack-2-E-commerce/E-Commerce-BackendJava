package cl.backend.javaSpring.dto;

import java.util.List;

import cl.backend.javaSpring.model.TipoEntregaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class CrearPedidoRequestDTO {

    private Long usuarioId;
    private TipoEntregaEnum tipoEntrega;
    private Integer numeroMesa;
    private String observaciones;
    private List<ItemPedidoRequestDTO> item;

}
