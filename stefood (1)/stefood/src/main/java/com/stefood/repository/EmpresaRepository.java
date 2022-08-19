package com.stefood.repository;

import com.stefood.modelo.Empresa;
import com.stefood.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

   Empresa findByNome(String nomeUsuario);

}

