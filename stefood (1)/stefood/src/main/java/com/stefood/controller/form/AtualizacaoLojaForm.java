package com.stefood.controller.form;

import com.stefood.modelo.Loja;

import com.stefood.repository.LojaRepository;


public class AtualizacaoLojaForm {

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Loja atualizar(Long id, LojaRepository lojaRepository) {
        Loja loja = lojaRepository.getOne(id);
        loja.setTipo(this.tipo);

        return loja;
    }
}
