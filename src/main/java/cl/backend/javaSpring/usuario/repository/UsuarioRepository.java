package cl.backend.javaSpring.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.backend.javaSpring.usuario.model.RolUsuarioEnum;
import cl.backend.javaSpring.usuario.model.UsuariosModel;
import java.util.List;


public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {

    Optional<UsuariosModel> findByEmail(String email);
    List<UsuariosModel> findByRol(RolUsuarioEnum rol);

}
