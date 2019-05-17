package HAST;

import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcionesBD {
    static List<Socio> listaSocioMayorDeEdad = new ArrayList<>();


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

    static void SeleccionarMayoresDe18() {
        Connection conexion = BD.getConn();
        listaSocioMayorDeEdad.clear();


        try {
            Statement mayorDe18 = conexion.createStatement();
            ResultSet mayoresDeEdad = mayorDe18.executeQuery("select codigoSocio from Socio where Sysdate-fechaNacimiento>=6574");
            while (mayoresDeEdad.next()) {


                Socio nuevoSocio = new Socio(mayoresDeEdad.getInt("codigoSocio"));


                listaSocioMayorDeEdad.add(nuevoSocio);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    static boolean BorrarSocio(int codigoSocio) {
        boolean resultBorrado = false;
        Connection conexion = BD.getConn();

        try {
            String sql = "Delete from Socio where codigoSocio = " + codigoSocio;
            Statement borrar = conexion.createStatement();

            int valor = borrar.executeUpdate(sql);
            if (valor>1){
                resultBorrado=true;
            }
            conexion.close();//ceramos
            borrar.close();

        } catch (SQLException e) {
            //Imprime el mensaje de la exception lanzada en pl/sql si el valor es diferente de 1
            e.printStackTrace();
        }

return resultBorrado;
    }


}





