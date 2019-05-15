package HAST;

import com.github.lgooddatepicker.components.CalendarPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AcionesBD {

    List<Socio> listaSocioMayorDeEdad = new ArrayList<>();


    //comprobar contraseña

    static boolean ComprobarContraseña(int codigoUsuario, String DNIUsuario) {
        Connection conexion = BD.getConn();

        boolean confirm=false;





            try {


                PreparedStatement comprobarContraseña = conexion.prepareStatement("select * from socio where codigoSocio=? and DNI=?");
                comprobarContraseña.setInt(1, codigoUsuario);
                comprobarContraseña.setString(2, DNIUsuario);
                ResultSet resp  = comprobarContraseña.executeQuery();




                    System.out.println("pasa");

                if(resp!=null){ confirm=true;}

            } catch (SQLException e) {

            }


        return confirm;
    }

    static java.sql.ResultSet SeleccionarMayoresDe18() {
        Connection conexion = BD.getConn();
        ResultSet mayoresDeEdad = null;
        String consulta="{select codigoSocio from Socio where Sysdate-fechaNacimiento>=6574 }";
        try {
            Statement mayorDe18 = conexion.createStatement();

            mayoresDeEdad = mayorDe18.executeQuery(consulta);
            while (mayoresDeEdad.next()) {


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return mayoresDeEdad;

    }


    public static class Calendario {
        private JPanel calendario;

        private CalendarPanel calendarioActivadades;
        private JLabel fecha;
        private JButton Aceptar;
        private JLabel dia;


        public JPanel getCalendario() {
            return calendario;
        }

        public Calendario() {

            Aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LocalDate seleccion = calendarioActivadades.getSelectedDate();
                    fecha.setText(seleccion.toString());
                    dia.setText(calendarioActivadades.getSelectedDate().getDayOfWeek().toString());
                }


            });


        }
    }
}





