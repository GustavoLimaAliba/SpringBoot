package com.stefood.controller.dto;

public class TokenTesteDto {
    private String token;
    private String tipo;
    public TokenTesteDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
