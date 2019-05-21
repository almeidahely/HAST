package HAST;


import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccionesBD {
      static List<Socio> listaSocioMayorDeEdad = new ArrayList<>();
      static List<Actividad> listaActividades = new ArrayList<>();
      static  Map<Integer, Socio> socios = new HashMap<>();
      static Map<Integer,Cargo> cargos = new HashMap<>();
      static Map<Integer,Socio> MapMAyoresDeEdad = new HashMap<>();

    static List<String> nombreUsuarioConectado = new ArrayList<>();


    public static List<Socio> getListaSocioMayorDeEdad() {
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



            //int codigoSocio, String DNI, String telefono, String nombre, String apellido, String fechaNacimiento, String email, int edad, String fechaAlta, String fechaBaja
                Socio nuevoSocio = new Socio(mayoresDeEdad.getInt("codigoSocio"),mayoresDeEdad.getString("DNI") ,mayoresDeEdad.getString("telefono"),mayoresDeEdad.getString("nombre"), mayoresDeEdad.getString("apellido"),mayoresDeEdad.getString("fechaNacimiento"),mayoresDeEdad.getString("email"),mayoresDeEdad.getString("fechaAlta"),mayoresDeEdad.getString("fechaBaja"));
                listaSocioMayorDeEdad.add(nuevoSocio);
                MapMAyoresDeEdad.put(nuevoSocio.getCodigoSocio(),nuevoSocio);


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
        listaActividades.clear();
        Connection conexion = BD.getConn();

        try {
            Statement actividad = conexion.createStatement();
            ResultSet activas = actividad.executeQuery("select * from ACTIVIDAD ");

            while (activas.next()) {
                int organizador = activas.getInt("organizador");
                for (Socio socio : listaSocioMayorDeEdad) {
                    if(organizador == socio.getCodigoSocio()){
                        Actividad nuevaActividad = new Actividad(activas.getInt("codigoActividad"), activas.getString("descripcion"), activas.getDouble("precio"), socio, activas.getString("tipo"), activas.getString("dificultad"),activas.getString("fechaActividad"));
                        nuevaActividad.setOrganizador(socio);
                        socio.listaActividadesOrganizadas.add(nuevaActividad);
                    }
                }        listaActividades.clear();
                for (Socio socio : listaSocioMayorDeEdad) {
                   listaActividades.addAll(socio.listaActividadesOrganizadas) ;
                }
                    }
                }




         catch (SQLException e) {
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

                for (Socio socio : listaSocioMayorDeEdad) {
                    int codigoResponsable = resultSetSocio.getInt("codigoResponsable");

                    if (0<codigoResponsable)    {

                         nuevoSocioMenor = new Socio(resultSetSocio.getInt("codigoSocio"), resultSetSocio.getString("DNI"), resultSetSocio.getString("telefono"), resultSetSocio.getString("nombre"), resultSetSocio.getString("apellido"), resultSetSocio.getString("fechaNacimiento"), resultSetSocio.getString("email"),socio, resultSetSocio.getString("fechaAlta"), resultSetSocio.getString("fechaBaja"));
                        socio.getListaMenoresACargo().add(nuevoSocioMenor);
                        nuevoSocioMenor.setCodigoResponsable(socio);
                        socios.put(socio.getCodigoSocio(),socio);
                }
                    else{
                         nuevoSocioMayor = new Socio(resultSetSocio.getInt("codigoSocio"),resultSetSocio.getString("DNI") ,resultSetSocio.getString("telefono"),resultSetSocio.getString("nombre"), resultSetSocio.getString("apellido"),resultSetSocio.getString("fechaNacimiento"),resultSetSocio.getString("email"),resultSetSocio.getString("fechaAlta"),resultSetSocio.getString("fechaBaja"));
                        socios.put(resultSetSocio.getInt("codigoSocio"),socio);

                    }


                //orden de los campos en BD: Nombre, Apellido, DNI, codigoSocio, Telefono, email, Perfil, fechaAlta, fechaBaja, fechaNacimiento, codigoResponsable



            }}


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void añadirSocioNuevo ( String nombre,String apellido,String DNI, String telefono,    String email, String fechaDeNacimiento){
        Connection conexion = BD.getConn();

        try {
            String añadirSocio= "{call CrearNuevoSocio(?,?,?,?,?,?,?)}";

            CallableStatement añadido =conexion.prepareCall(añadirSocio);
            añadido.setString(1,nombre);
            añadido.setString(3,DNI);
            añadido.setString(4,telefono);
            añadido.setString(2,apellido);
            añadido.setString(6,fechaDeNacimiento);
            añadido.setString(5,email);
             LocalDate fecha= LocalDate.now();

            añadido.execute();
//if (period< ){}



        } catch (SQLException e) {
            System.out.println("no añadido ");
        }

    }

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

    static void RellenarListaCargos(){
        Connection conexion = BD.getConn();
        try {
            Statement todosCargo = conexion.createStatement();
            ResultSet resultCargo = todosCargo.executeQuery("select * from Cargo");

            Cargo nuevoCargo = new Cargo(resultCargo.getInt("codigoCargo"), resultCargo.getString("nombreCargo"));
            cargos.put(resultCargo.getInt("codigoCargo"),nuevoCargo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}








