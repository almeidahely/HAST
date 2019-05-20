package HAST;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int codigoActividad;
    private String descripcion;
    private double precio;
    private Socio organizador;
    private String dificultad;
    private String tipo;
    List<Socio> participantes =new ArrayList<>();
    private String fechaActividad;


    public Actividad(int codigoActividad, String descripcion, double precio, Socio organizador, String dificultad, String tipo, String fechaActividad) {
        this.codigoActividad = codigoActividad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.organizador = organizador;
        this.dificultad = dificultad;
        this.tipo = tipo;
        this.fechaActividad = fechaActividad;
    }



    public int getCodigoActividad() {
        return codigoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Socio getOrganizador() {
        return organizador;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }
}
