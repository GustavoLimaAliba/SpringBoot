package com.stefood.repository;



import com.stefood.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByNome(String nomeProduto);

}
