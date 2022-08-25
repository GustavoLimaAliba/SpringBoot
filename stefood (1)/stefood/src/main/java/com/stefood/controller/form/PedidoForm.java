package com.stefood.controller.form;
import com.stefood.modelo.Empresa;
import com.stefood.modelo.Pedido;
import com.stefood.repository.EmpresaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class PedidoForm {

   @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 3)
    private String mensagem;
    @NotNull @NotEmpty @Length(min = 2)
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
