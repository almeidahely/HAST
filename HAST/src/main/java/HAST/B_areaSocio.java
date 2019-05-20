package HAST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class B_areaSocio extends Container {
    public JPanel socioPanel;
    private JButton laJuntaButton;
    private JButton verCalendarioButton;
    private JButton actividadesButton;
    private JButton datosPersonalesButton;
    private JPanel Panel;
    private JLabel usuarioEntrada;
    private JButton SalirButtonSocios;
    private JLabel hora;

    public JPanel getSocioPanel() {
        return socioPanel;
    }

    String nombreUsuario, apellidoUsuario;

    public B_areaSocio(JFrame frame) {


        //Muestra el nombre del usuario, quitando los corchetes
        String nombreConectado = AccionesBD.nombreUsuarioConectado.toString();
        nombreConectado = nombreConectado.substring(1, nombreConectado.length() - 1);


        LocalDate fechaHoy = LocalDate.now();

        usuarioEntrada.setText(String.format("Bienenid@ " + nombreConectado));
        hora.setText("Fecha de hoy: " + fechaHoy.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));


        datosPersonalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Datos personales");
                frame.setContentPane(new BA_VentanaDatosPersonales(frame).Principal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        actividadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Listado de actividades");
                frame.setContentPane(new BB_VentanaListadoActividades(frame).getPrincipal());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        verCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("");
                frame.setContentPane(new BC_Calendario().getPanelCalendario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        laJuntaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("La junta");
                frame.setContentPane(new BD_JuntaSocio().panel1);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        SalirButtonSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        datosPersonalesButton = new JButton(new ImageIcon("datospersonales.png"));
        actividadesButton = new JButton(new ImageIcon("actividadesSocio.png"));
        verCalendarioButton = new JButton(new ImageIcon("calendar.png"));
        laJuntaButton = new JButton(new ImageIcon("laJunta.png"));
        SalirButtonSocios = new JButton(new ImageIcon("exit2.png"));


    }
}