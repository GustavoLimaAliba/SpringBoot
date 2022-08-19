package com.stefood.controller.form;

import com.stefood.modelo.Pedido;
import com.stefood.repository.PedidoRepository;

public class AtualizacaoPedidoForm {

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
