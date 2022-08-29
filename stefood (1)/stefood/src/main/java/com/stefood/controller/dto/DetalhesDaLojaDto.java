package com.stefood.controller.dto;

import com.stefood.modelo.Loja;

import com.stefood.modelo.StatusPedido;

import java.time.LocalDateTime;


public class DetalhesDaLojaDto {
    private Long id;
    private String titulo;
    private String tipo;
    private LocalDateTime dataDeEntrega;


    private String produto;



    private StatusPedido status;









    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(LocalDateTime dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    public DetalhesDaLojaDto(Loja loja){
        this.id = loja.getId();
        this.titulo = loja.getTitulo();
        this.tipo = loja.getTipo();
        this.dataDeEntrega = loja.getDataDeEntrega();
        this.produto = loja.getProduto().getNome();
        this.status = loja.getStatus();



    }


    }


