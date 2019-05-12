package com.company;

public class Junta {
    private Socio codigoSocio;
    private Cargo codigoCargo;
    private String fechaInicio;
    private String fechaFin;
    private int numAjuntado;

    public Junta(Socio codigoSocio, Cargo codigoCargo, String fechaInicio, String fechaFin, int numAjuntado) {
        this.codigoSocio = codigoSocio;
        this.codigoCargo = codigoCargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numAjuntado = numAjuntado;
    }
}
