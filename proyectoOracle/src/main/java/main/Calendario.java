package main;

import com.github.lgooddatepicker.components.CalendarPanel;


import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Calendario {
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