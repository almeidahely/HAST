package HAST;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    public Socio getCodigoSocio() {
        return codigoSocio;
    }

    public Cargo getCodigoCargo() {
        return codigoCargo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }


}
