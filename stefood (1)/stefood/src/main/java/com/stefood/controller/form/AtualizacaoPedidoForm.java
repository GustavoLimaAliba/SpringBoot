package com.stefood.controller.form;

import com.stefood.modelo.Pedido;
import com.stefood.repository.PedidoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoPedidoForm {
@NotNull @NotEmpty @Length(min = 5)
    private String mensagem;


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {
        Pedido pedido = pedidoRepository.getOne(id);
        pedido.setMensagem(this.mensagem);

        return pedido;
    }
}
