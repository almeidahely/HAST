package com.company;

public class Socio {

    private int codigoSocio;
    private String DNI;
    private String telefono;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String email;
    private Socio DNIResponsable;
    private int edad;
    private String fechaAlta;
    private String fechaBaja;
    private String nombreCargo;

    public Socio(int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, Socio DNIResponsable, int edad, String fechaAlta, String fechaBaja, String nombreCargo) {
        this.codigoSocio = codigoSocio;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.DNIResponsable = DNIResponsable;
        this.edad = edad;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.nombreCargo = nombreCargo;
    }
}
