package io.github.vagnereix.clientes.model.repository;

import io.github.vagnereix.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
