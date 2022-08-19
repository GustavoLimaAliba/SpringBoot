package com.stefood.repository;

import com.stefood.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByEmpresa_Nome(String nomeEmpresa);

}
