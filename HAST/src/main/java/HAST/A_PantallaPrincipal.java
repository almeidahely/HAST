package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class A_PantallaPrincipal {

    static int socioUsuario;

    private JPanel Principal;
    private JTextField textNombreUsuario;
    private JButton aceptarButton;
    private JComboBox lista;
    private JButton buttonCabeceraPrincipal;
    private JPanel Fondo;
    private JPasswordField passwordField1passwordField1;
    private JButton iconUser;
    private JButton iconPassword;
    private JButton calendarioButton;

    static List<String> usuarioConectado = new ArrayList<>();


    public JTextField getTextNombreUsuario() {
        return textNombreUsuario;
    }

    public JPanel getPrincipal() {
        return Principal;
    }

    public A_PantallaPrincipal() {


//Listado de socio//
        AccionesBD.SeleccionarMayoresDe18();
        AccionesBD.listarActividades();

        System.out.println(AccionesBD.listaSocioMayorDeEdad.size());
        System.out.println(AccionesBD.listaActividades.size());



        //Listado de Socio//
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoUsuario = Integer.parseInt(textNombreUsuario.getText());
                int valor = AccionesBD.ComprobarContraseña(codigoUsuario, String.valueOf(passwordField1passwordField1.getPassword()));


                //Nombre del usuario Logueado / conectado.
                AccionesBD.usuarioConectado(codigoUsuario);




                if (valor != 0) {

                    if (valor == 1) {

                        JFrame frame = new JFrame("BC_Calendario");
                        frame.setContentPane(new B_areaSocio(frame).getSocioPanel());
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    } else {
                        JFrame frame = new JFrame("Administrador");
                        frame.setContentPane(new AA_accesoAdmin().getPanel());
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);

                    }
                    socioUsuario = codigoUsuario;

                    passwordField1passwordField1.setText("");
                    textNombreUsuario.setText("");


                } else {

                }

            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("A_PantallaPrincipal");
        frame.setContentPane(new A_PantallaPrincipal().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        Connection con = BD.conexion();

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonCabeceraPrincipal = new JButton((new ImageIcon("cabecera.png")));
        iconPassword = new JButton(new ImageIcon("password.png"));
        iconUser = new JButton(new ImageIcon("userLogin.png"));
        aceptarButton = new JButton(new ImageIcon("sign-in.png"));


    }

    public static int getSocioUsuario() {
        return socioUsuario;
    }
}

