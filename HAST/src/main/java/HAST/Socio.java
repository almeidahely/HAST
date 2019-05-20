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
    private int codigoResponsable;
    private int edad;
    private String fechaAlta;
    private String fechaBaja;
    private String nombreCargo;
    private String perfil;


    static List<Socio> listaSocio = new ArrayList<>();


    public Socio(int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, int codigoResponsable, int edad, String fechaAlta, String fechaBaja) {

        this.codigoSocio = codigoSocio;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.codigoResponsable = codigoResponsable;
        this.edad = edad;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }


    public Socio(int codigoSocio, String nombre, String apellido) {
        this.codigoSocio = codigoSocio;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public int getCodigoResponsable() {
        return codigoResponsable;
    }

    public int getEdad() {
        return edad;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }
}
