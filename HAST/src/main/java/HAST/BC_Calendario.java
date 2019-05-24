package HAST;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BC_Calendario {

    private JPanel panel;
    public CalendarPanel calendarioActivadades;
    private JLabel fecha;
    private JButton Aceptar;
    private JLabel dia;
    public LocalDate seleccion;// = calendarioActivadades.getSelectedDate();




    public JPanel getPanelCalendario() {

        return panel;
    }



    public BC_Calendario() {



        Locale spain = new Locale("es");
        calendarioActivadades.setLocale(spain);

        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = calendarioActivadades.getSelectedDate();
                fecha.setText(seleccion.toString());
                dia.setText(calendarioActivadades.getSelectedDate().getDayOfWeek().toString());

                Connection conexion = BD.getConn();

                try {
                    String query = "SELECT * FROM actividad";

                    //Statement
                    Statement st = conexion.createStatement();

                    // Ejecuta el Query y consigue el valor
                    ResultSet rs = st.executeQuery(query);

                    // Itinerar a traves del result
                    while (rs.next()) { //FUNCIONA :O
                        Date dateCreated = rs.getDate("fechaActividad");

                    System.out.println(dateCreated);


                    if (!dateCreated.toLocalDate().equals(seleccion)) {
                        JFrame frame = new JFrame("Ventana de organizar actividad");
                        frame.setContentPane(new BCB_VentanaOrganizarActividad(seleccion).Principal);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    } else {
                        JFrame frame = new JFrame("Ventana listado actividad");
                        frame.setContentPane(new BB_VentanaListadoActividades(frame).Principal);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    }
                } catch (SQLException ee){
                    ee.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BC_Calendario");
        frame.setContentPane(new BC_Calendario().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        DatePicker datePicker;
        DatePickerSettings dateSettings;


    }
}
