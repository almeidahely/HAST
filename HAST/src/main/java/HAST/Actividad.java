package HAST;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int codigoActividad;
    private String descripcion;
    private double precio;
    private int organizador;
    List<Socio> participantes =new ArrayList<>();
    private String fechaActividad;



    public Actividad(int codigoActividad, String descripcion, double precio, int organizador,String fechaActividad) {
        this.codigoActividad = codigoActividad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.organizador=organizador;
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

    public int getOrganizador() {
        return organizador;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }
}
