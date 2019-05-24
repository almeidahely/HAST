package HAST;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

                JFrame frame = new JFrame("Ventana de organizar actividad");
                frame.setContentPane(new BCB_VentanaOrganizarActividad(seleccion).Principal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
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
