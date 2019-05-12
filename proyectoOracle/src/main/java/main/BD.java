package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {

    public BD(Connection conexion) {
        this.conexion = conexion;
    }

    public static void main(String[] args) {

    }
        private static   Connection conexion;

        public static Connection conectar() {

            try {

                if (conexion == null || conexion.isClosed()) {

                    // Driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Cadena de conexión
                    String servidor = "192.168.33.10";
                    String puerto = "3306";
                    String bd = "videoclub";
                    String login = "anderZ";
                    String password = "";
                    String opciones = "?verifyServerCertificate=false&useSSL=true&requireSSL=false";
                    String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + bd + opciones;

                    // Establecimiento de conexión
                    conexion = DriverManager.getConnection(url, login, password);
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return conexion;
    }
}
