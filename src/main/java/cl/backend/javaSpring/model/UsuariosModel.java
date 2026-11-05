package cl.backend.javaSpring.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "apellidos", nullable = false)
    private String apellidos;

    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "fecha_nacimiento", nullable = true)
    private Date fechaNacimiento;

    @Column (name = "region", nullable = false)
    private String region;

    @Column (name = "comuna", nullable = false)
    private String comuna;

    @Column (name = "direccion", nullable = false)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private RolUsuarioEnum rol;

}
