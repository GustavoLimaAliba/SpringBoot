package com.stefood.controller.dto;

import com.stefood.modelo.Pedido;
import com.stefood.modelo.StatusPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoPedidoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String pessoa;
    private StatusPedido status;
    private List<RespostaDto> respostas;


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

    public String getPessoa() {
        return pessoa;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<RespostaDto> getRespostas() {
        return respostas;
    }

    public DetalhesDoPedidoDto(Pedido pedido){
        this.id = pedido.getId();
        this.titulo = pedido.getTitulo();
        this.mensagem = pedido.getMensagem();
        this.dataCriacao = pedido.getDataCriacao();
        this.pessoa = pedido.getPessoa().getNome();
        this.status = pedido.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(pedido.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));

    }
}
