package cl.backend.javaSpring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table (name = "detalle_pedidos")
public class DetallePedidoModel {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn (name = "pedido_id", nullable = false)
    private PedidosModel pedido;

    @ManyToOne
    @JoinColumn (name = "producto_id", nullable = false)
    private ProductosModel producto;

    @Column (name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column (name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column (name = "subtotal", nullable = false)
    private Double subtotal;

    @Column (name = "notas_especiales", nullable = true)
    private String notasEspeciales; // "Sin cebolla", "Sin mayo", etc...

}
