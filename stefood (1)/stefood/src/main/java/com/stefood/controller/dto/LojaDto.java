package com.stefood.controller.dto;

import com.stefood.modelo.Loja;
import com.stefood.modelo.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LojaDto {
    private Long id;
    private String titulo;
    private String tipo;

    private LocalDateTime dataDeEntrega;





    public LojaDto(Loja loja){
        this.id = loja.getId();
        this.titulo = loja.getTitulo();
        this.tipo =loja.getTipo();
        this.dataDeEntrega = loja.getDataDeEntrega();


    }

    public static List<LojaDto> converter(List<Loja> lojas) {
        return lojas.stream().map(LojaDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return tipo;
    }

    public LocalDateTime getDataDeEntrega() {
        return dataDeEntrega;
    }
}
