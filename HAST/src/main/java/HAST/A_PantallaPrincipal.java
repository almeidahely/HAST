package HAST;

import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PantallaPrincipal {



    private JPanel Principal;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton aceptarButton;
    private JPanel Fondo;
    private JComboBox listaMayoresEdad;
    private JButton calendarioButton;


    public JPanel getPrincipal() {
        return Principal;
    }

    public PantallaPrincipal() {
//Listado de socio//
AcionesBD.SeleccionarMayoresDe18();

        for (Socio socio : AcionesBD.listaSocioMayorDeEdad) {
            listaMayoresEdad.addItem(socio.getCodigoSocio()+" "+socio.getNombre()+" "+socio.getApellido());


        }

        //Listado de Socio//
aceptarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigoUsuario = Integer.parseInt(textField1.getText());
        int valor= AcionesBD.ComprobarContraseña(codigoUsuario,String.valueOf(passwordField1.getPassword()));
        AcionesBD.SeleccionarMayoresDe18();
        if(valor!=0){

            if(valor==1){

                JFrame frame = new JFrame("Calendario");
                frame.setContentPane(new areaSocio().getSocioPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);}
            else{
                JFrame frame = new JFrame("Administrador");
                frame.setContentPane(new accesoAdmin().getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }

        }
        else{
            ;
        }

    }
});


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PantallaPrincipal");
        frame.setContentPane(new PantallaPrincipal().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        Connection con = BD.conexion();

}}

