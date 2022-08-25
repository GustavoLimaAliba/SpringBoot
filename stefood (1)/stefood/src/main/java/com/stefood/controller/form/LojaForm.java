package com.stefood.controller.form;


import com.stefood.modelo.Loja;
import com.stefood.modelo.Produto;
import com.stefood.repository.LojaRepository;
import com.stefood.repository.ProdutoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LojaForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String tipo;
    @NotNull
    @NotEmpty
    @Length(min = 2)
    private String nomeProduto;





    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Loja converter(ProdutoRepository produtoRepository) {
        Produto produto = produtoRepository.findByNome(nomeProduto);
        return new Loja(titulo, tipo, produto);
    }
}
