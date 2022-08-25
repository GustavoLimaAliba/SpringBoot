package com.stefood.controller.dto;

import com.stefood.modelo.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDto {
    private Long id;
    private String titulo;
    private String mensagem;

    private LocalDateTime dataCriacao;





    public PedidoDto(Pedido pedido){
        this.id = pedido.getId();
        this.titulo = pedido.getTitulo();
        this.mensagem = pedido.getMensagem();
        this.dataCriacao = pedido.getDataCriacao();


    }

    public static List<PedidoDto> converter(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
