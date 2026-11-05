package cl.backend.javaSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoRequestDTO {

    private Long productoId;
    private Integer cantidad;
    private String notasEspeciales;

}
