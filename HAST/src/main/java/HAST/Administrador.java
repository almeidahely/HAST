//package HAST;
//
//public class Administrador extends Socio {
//
//
//   public Administrador(int codigoSocio, String nombre, String apellido) {
//        super(codigoSocio, nombre, apellido);
//    }
//}

public class Administrador extends Socio {

    public Administrador(int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, Socio codigoResponsable, int edad, String fechaAlta, String fechaBaja) {
        super(codigoSocio, DNI, telefono, nombre, apellido, fechaNacimiento, email, codigoResponsable, edad, fechaAlta, fechaBaja);
    }
}
