package HAST;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccionesBD {

    static List<Socio> listaSocioMayorDeEdad = new ArrayList<>();
    static List<Actividad> listaActividades = new ArrayList<>();
    static Map<Integer, Socio> socios = new HashMap<>();
    static Map<Integer, Cargo> cargos = new HashMap<>();
    static List<String> nombreUsuarioConectado = new ArrayList<>();


    public List<Socio> getListaSocioMayorDeEdad() {
        return listaSocioMayorDeEdad;
    }


    //comprobar contraseña

    static int ComprobarContraseña(int codigoUsuario, String DNIUsuario) {
        Connection conexion = BD.getConn();

        int confirm = 0;
        ResultSet resp = null;
        String perfil = null;


        try {


            PreparedStatement comprobarContraseña = conexion.prepareStatement("select * from socio where codigoSocio=? and DNI=?");
            comprobarContraseña.setInt(1, codigoUsuario);
            comprobarContraseña.setString(2, DNIUsuario);

            resp = comprobarContraseña.executeQuery();


            System.out.println("pasa");
            while (resp.next()) {
                perfil = resp.getString("perfil");
            }


            System.out.println("por aqui");
            System.out.println(perfil);

            switch (perfil) {
                case "usuario":
                    confirm = 1;
                    break;

                case "administrador":
                    confirm = 2;
                    break;

                default:
                    confirm = 0;
                    break;
            }


        } catch (SQLException e) {

        }


        return confirm;
    }
    //Lista Mayores de 18

    static void SeleccionarMayoresDe18() {
        Connection conexion = BD.getConn();
        listaSocioMayorDeEdad.clear();


        try {
            Statement mayorDe18 = conexion.createStatement();
            ResultSet mayoresDeEdad = mayorDe18.executeQuery("select * from Socio where Sysdate-fechaNacimiento>=6574");
            while (mayoresDeEdad.next()) {


                Socio nuevoSocio = new Socio(mayoresDeEdad.getInt("codigoSocio"), mayoresDeEdad.getString("DNI"), mayoresDeEdad.getString("nombre"), mayoresDeEdad.getString("apellido"), mayoresDeEdad.getString("email"), mayoresDeEdad.getString("fechaNacimiento"));
                listaSocioMayorDeEdad.add(nuevoSocio);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    /*
    Enseña el nombre del usuario conectado
    @param: define el código del socio para encontrar el nombre del usuario
     */

    static void usuarioConectado(int codigoSocio) {
        Connection conexion = BD.getConn();
        nombreUsuarioConectado.clear();

        try {
            Statement stmt = conexion.createStatement();


            PreparedStatement Pstmt = conexion.prepareStatement("select * from Socio where codigoSocio = ?");
            Pstmt.setObject(1, codigoSocio);


            ResultSet userConnected_ = Pstmt.executeQuery();
            while (userConnected_.next()) {
                userConnected_.getString("Nombre");

                String nombres = userConnected_.getString("Nombre");
                nombreUsuarioConectado.add(nombres);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }









    //Lista Actividades

    static void listarActividades() {
        Connection conexion = BD.getConn();
        SeleccionarMayoresDe18();

        try {
            Statement actividad = conexion.createStatement();
            ResultSet activas = actividad.executeQuery("select * from ACTIVIDAD where cancelado= 'activo'");
            SeleccionarMayoresDe18();


            while (activas.next()) {
                int organizador = activas.getInt("organizador");
                for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                    if (organizador == socio.getCodigoSocio()) {
                        Actividad nuevaActividad = new Actividad(activas.getInt("codigoActividad"), activas.getString("descripcion"), activas.getDouble("precio"), socio, activas.getString("fechaActividad"), activas.getString("tipo"), activas.getString("dificultad"));

                for (Socio socio : listaSocioMayorDeEdad) {
                    for (Actividad activi : socio.listaActividadesOrganizadas) {
                        listaActividades.add(activi);
                    }
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    static void TodosLosSocios() {
        Connection conexion = BD.getConn();
        socios.clear();
        SeleccionarMayoresDe18();
        Socio nuevoSocioMenor,nuevoSocioMayor;

        try {
            Statement todoSocios = conexion.createStatement();
            ResultSet resultSetSocio = todoSocios.executeQuery("select * from Socio ");

            while (resultSetSocio.next()) {

                int codigoResponsable = resultSetSocio.getInt("codigoResponsable");
                for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                    if (socio.getCodigoSocio() == codigoResponsable) {

                        nuevoSocio = new Socio(resultSetSocio.getInt("codigoSocio"), resultSetSocio.getString("DNI"), resultSetSocio.getString("telefono"), resultSetSocio.getString("nombre"), resultSetSocio.getString("apellido"), resultSetSocio.getString("fechaNacimiento"), resultSetSocio.getString("email"), socio, resultSetSocio.getInt("edad"), resultSetSocio.getString("fechaDeAlta"), resultSetSocio.getString("fechaDeBaja"));

                    }

                    //orden de los campos en BD: Nombre, Apellido, DNI, codigoSocio, Telefono, email, Perfil, fechaAlta, fechaBaja, fechaNacimiento, codigoResponsable


                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void añadirSocioNuevo(int codigo, String DNI, String telefono, String nombre, String apellido, String fechaDeNacimiento, String email, int edad, String fechaDeAlta, String fechaDeBaja) {
        Connection conexion = BD.getConn();

        try {
            String añadirSocio = "{call CrearNuevoSocio(default,?,?,?,?,?,?,?,default,null)}";

            CallableStatement añadido = conexion.prepareCall(añadirSocio);
            añadido.setString(1, DNI);
            añadido.setString(2, telefono);
            añadido.setString(3, nombre);
            añadido.setString(4, apellido);
            añadido.setString(5, fechaDeNacimiento);
            añadido.setString(6, email);
            añadido.setInt(7, edad);

            Period period = Period.between(fecha,CDA_AnadirSocios.selectorFecha.getDate());
            añadido.execute();
//if (period){}


        } catch (SQLException e) {
            System.out.println("no añadido ");
        }

    }


    //*
    // ELIMINAR Actividad

    static void Eliminar_Actividad(String nombre) {
        Connection conexion = BD.getConn();

        int respuesta = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar a " + nombre);
        if (respuesta == JOptionPane.YES_OPTION) {

            String sql = "Delete from ACTIVIDAD" + "where nombre =?";
            try {
                PreparedStatement elimin = conexion.prepareStatement(sql);
                elimin.setString(1, nombre);
                //elimin.executeUpdate();

                if (elimin.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado!");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido  eliminar.\n" +
                            "Intentelo nuevamente.");


                }
                elimin.close();
                conexion.close();

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "No se ha podido  eliminar.\n" +
                        "Intentelo nuevamente." + e);

                e.printStackTrace();
            }


        }


    }
}





