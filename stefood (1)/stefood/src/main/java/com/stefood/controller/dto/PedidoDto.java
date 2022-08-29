package com.stefood.controller.dto;

import com.stefood.modelo.Pedido;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDto {
    private Long id;
    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    private String mensagem;

    private LocalDateTime dataCriacao;





    public PedidoDto(Pedido pedido){
        this.id = pedido.getId();
        this.titulo = pedido.getTitulo();
        this.mensagem = pedido.getMensagem();
        this.dataCriacao = pedido.getDataCriacao();


    }

    public static Page<PedidoDto> converter(Page<Pedido> pedidos) {
        return pedidos.map(PedidoDto::new);
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
