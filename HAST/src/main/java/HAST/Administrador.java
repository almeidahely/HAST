package HAST;

public class Administrador extends Socio {


    public Administrador(int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, Socio DNIResponsable, int edad, String fechaAlta, String fechaBaja, String nombreCargo) {
        super(codigoSocio, DNI, telefono, nombre, apellido, fechaNacimiento, email, DNIResponsable, edad, fechaAlta, fechaBaja, nombreCargo);
    }
}
