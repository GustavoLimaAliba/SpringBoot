package com.stefood.controller.form;
import com.stefood.modelo.Empresa;
import com.stefood.modelo.Pedido;
import com.stefood.repository.EmpresaRepository;
import com.sun.istack.NotNull;

public class PedidoForm {

    @NotNull
    private String titulo;
    @NotNull
    private String mensagem;
    @NotNull
    private String nomeEmpresa;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Pedido converter(EmpresaRepository empresaRepository) {
        Empresa empresa = empresaRepository.findByNome(nomeEmpresa);
        return new Pedido(titulo, mensagem, empresa);
    }

}
