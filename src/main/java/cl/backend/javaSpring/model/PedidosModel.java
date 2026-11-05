package cl.backend.javaSpring.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "pedidos")
public class PedidosModel {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "usuario_id", nullable = false)
    private UsuariosModel usuario;

    @Column (name = "fecha_pedido", nullable = false)
    private LocalDateTime fechaPedido;

    @Enumerated (EnumType.STRING)
    @Column (name = "estado", nullable = false, length = 30)
    private EstadoPedidoEnum estado;

    @Enumerated (EnumType.STRING)
    @Column (name = "tipo_entrega", nullable = false, length = 30)
    private TipoEntregaEnum tipoEntrega;

    @Column (name = "numero_mesa", nullable = false)
    private Integer numeroMesa;

    @Column (name = "total", nullable = false)
    private Double total;

    @Column (name = "observaciones", nullable = true)
    private String observaciones;

}
