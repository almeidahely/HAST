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
    private JButton calendarioButton;


    public JPanel getPrincipal() {
        return Principal;
    }

    public PantallaPrincipal() {


aceptarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigo = Integer.parseInt(textField1.getText());

        if(AcionesBD.ComprobarContraseña(codigo,String.valueOf(passwordField1.getPassword()))){
            JFrame frame = new JFrame("Calendario");
            frame.setContentPane(new Calendario().getCalendario());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);}
        else{
            System.out.println("fallo");
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

