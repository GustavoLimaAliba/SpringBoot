package com.stefood.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Loja {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String titulo;
        private String tipo;
        private LocalDateTime dataDeEntrega = LocalDateTime.now();
        @Enumerated(EnumType.STRING)
        private StatusPedido status = StatusPedido.NAO_RESPONDIDO;



    @ManyToOne
        private Produto produto;


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Loja(String titulo, String tipo, Produto produto) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.produto = produto;
    }
    public Loja() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(LocalDateTime dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }













        @Override
        public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

        @Override
        public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Loja other = (Loja) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    }

