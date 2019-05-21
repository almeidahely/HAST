package HAST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Socio {

    private int codigoSocio;
    private String DNI;
    private String telefono;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String email;
    private Socio codigoResponsable;
    private String fechaAlta;
    private String fechaBaja;
     List<Socio> listaMenoresACargo = new ArrayList<>();
    List<Actividad> listaActividadesOrganizadas = new ArrayList<>();
    List<Actividad> ActividadesParticipante = new ArrayList<>();


    public Socio(int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, Socio codigoResponsable, String fechaAlta, String fechaBaja) {

        this.codigoSocio = codigoSocio;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.codigoResponsable = codigoResponsable;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;

    }


    public Socio(int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, String fechaAlta, String fechaBaja) {

        this.codigoSocio = codigoSocio;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;

    }


    public int getCodigoSocio() {
        return codigoSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Socio getCodigoResponsable() {
        return codigoResponsable;
    }


    public String getFechaAlta() {
        return fechaAlta;
    }

    public List<Socio> getListaMenoresACargo() {
        return listaMenoresACargo;
    }

    public List<Actividad> getListaActividadesOrganizadas() {
        return listaActividadesOrganizadas;
    }

    public List<Actividad> getActividadesParticipante() {
        return ActividadesParticipante;
    }

    public void setCodigoResponsable(Socio codigoResponsable) {
        this.codigoResponsable = codigoResponsable;
    }
}
