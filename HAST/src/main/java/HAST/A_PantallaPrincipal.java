package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class A_PantallaPrincipal {

static  int socioUsuario;

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

    public A_PantallaPrincipal() {
//Listado de socio//
AccionesBD.SeleccionarMayoresDe18();

        for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
            listaMayoresEdad.addItem(socio.getCodigoSocio()+" "+socio.getNombre()+" "+socio.getApellido());


        }

        //Listado de Socio//
aceptarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigoUsuario = Integer.parseInt(textField1.getText());
        int valor= AccionesBD.ComprobarContraseña(codigoUsuario,String.valueOf(passwordField1.getPassword()));
        AccionesBD.SeleccionarMayoresDe18();
        AccionesBD.TodosLosSocios();
        AccionesBD.listarActividades();
        if(valor!=0){

            if(valor==1){

                JFrame frame = new JFrame("BC_Calendario");
                frame.setContentPane(new B_areaSocio().getSocioPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);}
            else{
                JFrame frame = new JFrame("Administrador");
                frame.setContentPane(new AA_accesoAdmin().getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }
            socioUsuario=codigoUsuario;

        }
        else{
            ;
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

}}

