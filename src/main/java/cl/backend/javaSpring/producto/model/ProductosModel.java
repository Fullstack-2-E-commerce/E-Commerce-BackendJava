package cl.backend.javaSpring.producto.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity
@Table (name = "productos")
public class ProductosModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "codigo", nullable = false)
    private String codigo;

    @Column (name = "nombreProducto", nullable = false)
    private String nombreProducto;

    @Column (name = "descripcion", nullable = true)
    private String descripcion;

    @Column (name = "precio", nullable = false)
    private Double precio;

    @Column (name = "stock", nullable = false)
    private Integer stock;

    @Column (name = "stock_critico", nullable = true)
    private Integer stockCritico;

    @Column (name = "categoria", nullable = false)
    private String categoria;

    @Column (name = "imagen_url", nullable = true)
    private String imagenUrl;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column (name = "destacado", nullable = false)
    private Boolean destacado;

}
