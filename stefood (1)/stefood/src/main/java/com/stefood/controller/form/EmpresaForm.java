package com.stefood.controller.form;

import com.stefood.modelo.Empresa;
import com.stefood.modelo.Pedido;
import com.stefood.repository.EmpresaRepository;

public class EmpresaForm {
private String nomeEmpresa;
private String categoria;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
