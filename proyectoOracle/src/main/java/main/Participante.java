package com.company;

public class Participante {
    private Socio codigoSocio;
    private int codigoActividad;
    private String pagoActividad;

    public Participante(Socio codigoSocio, int codigoActividad, String pagoActividad) {
        this.codigoSocio = codigoSocio;
        this.codigoActividad = codigoActividad;
        this.pagoActividad = pagoActividad;
    }
}
