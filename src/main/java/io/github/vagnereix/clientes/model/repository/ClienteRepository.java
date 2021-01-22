package io.github.vagnereix.clientes.model.repository;

import io.github.vagnereix.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
