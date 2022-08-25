package com.stefood.repository;

import com.stefood.modelo.Loja;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LojaRepository extends JpaRepository<Loja, Long> {


    List<Loja> findByProduto_Nome(String nomeProduto);
}
