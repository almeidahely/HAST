package HAST;

import com.github.lgooddatepicker.components.CalendarPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccionesBD {
    static List<Socio> listaSocioMayorDeEdad = new ArrayList<>();
    static List<Actividad> listaActividades = new ArrayList<>();


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


                Socio nuevoSocio = new Socio(mayoresDeEdad.getInt("codigoSocio"),mayoresDeEdad.getString("nombre"),mayoresDeEdad.getString("apellido"));



                listaSocioMayorDeEdad.add(nuevoSocio);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Lista Actividades

    static void listarActividades(){
        listaActividades.clear();
        Connection conexion = BD.getConn();

        try {
            Statement actividad = conexion.createStatement();
            ResultSet activas = actividad.executeQuery("select * from ACTIVIDAD where cancelado= activo");

            while(activas.next()){            Actividad nuevaActividad = new Actividad(activas.getInt("codigoActividad"),activas.getString("descripcion"),activas.getDouble("precio"), activas.getInt("organizador"),activas.getString("fechaActividad"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    static void TodosLosSocios() {
        Connection conexion = BD.getConn();
        Socio.socios.clear();


        try {
            Statement todoSocios = conexion.createStatement();
            ResultSet resultSetSocio = todoSocios.executeQuery("select * from Socio ");
            while (resultSetSocio.next()) {


                Socio nuevoSocio = new Socio(resultSetSocio.getInt("codigoSocio"),resultSetSocio.getString("DNI"),resultSetSocio.getString("telefono"),resultSetSocio.getString("nombre"),resultSetSocio.getString("apellido"),resultSetSocio.getString("fechaNacimiento"),resultSetSocio.getString("email"),resultSetSocio.getInt("codigoResponsable"),resultSetSocio.getInt("edad"),resultSetSocio.getString("fechaDeAlta"),resultSetSocio.getString("fechaDeBaja"));



                Socio.socios.put(resultSetSocio.getInt("codigoSocio"),nuevoSocio);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}





