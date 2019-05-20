package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CDA_AnadirSocios {
    private JPanel panel;
    private JComboBox selectorPerfil;
    private JComboBox selectorResponsable;
    private JButton buttonCancelar;
    private JButton buttonAnadir;
    private JTextField textDNI;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textFechaNacimiento;
    private JTextField textTelefono;
    private JTextField textEmail;

    static List<Socio> litaSocios = new ArrayList<>();


    public CDA_AnadirSocios(JFrame frame) {
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //anyadirSociosBd();

                textNombre.setText("");
                textApellidos.setText("");
                textTelefono.setText("");
                textEmail.setText("");
                textFechaNacimiento.setText("");


            }
        });


    }

/*  hely trabajando en esto.

private void anyadirSociosBd() {
        Connection conexion = BD.getConn();

        litaSocios.clear();

        try {
            PreparedStatement Pstmt = conexion.prepareStatement("insert into SOCIO (NOMBRE,APELLIDO,DNI,TELEFONO,EMAIL,PERFIL,FECHAALTA,FECHANACIMIENTO) VALUES(?,?,?,?,?,?,?,?)");


            //selector Fecha Alta
            LocalDate fecha = LocalDate.now();


            Pstmt.setString(1, textNombre.getText());
            Pstmt.setString(2, textApellidos.getText());
            Pstmt.setString(3, textDNI.getText());
            Pstmt.setString(4, textTelefono.getText());
            Pstmt.setString(5, textEmail.getText());
            Pstmt.setString(6, String.valueOf(selectorPerfil.getSelectedItem()));
            Pstmt.setString(7, fecha.toString());
            Pstmt.setString(8, textFechaNacimiento.getText());

            int filas = Pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + filas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public JPanel getPanel() {
        return panel;
    }


    static void anyadirSocio() {


    }


    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JComboBox getSelectorPerfil() {
        return selectorPerfil;
    }

    public void setSelectorPerfil(JComboBox selectorPerfil) {
        this.selectorPerfil = selectorPerfil;
    }

    public JComboBox getSelectorResponsable() {
        return selectorResponsable;
    }

    public void setSelectorResponsable(JComboBox selectorResponsable) {
        this.selectorResponsable = selectorResponsable;
    }

    public JButton getButtonCancelar() {
        return buttonCancelar;
    }

    public void setButtonCancelar(JButton buttonCancelar) {
        this.buttonCancelar = buttonCancelar;
    }

    public JButton getButtonAnadir() {
        return buttonAnadir;
    }

    public void setButtonAnadir(JButton buttonAnadir) {
        this.buttonAnadir = buttonAnadir;
    }

    public JTextField getTextDNI() {
        return textDNI;
    }

    public void setTextDNI(JTextField textDNI) {
        this.textDNI = textDNI;
    }

    public JTextField getTextNombre() {
        return textNombre;
    }

    public void setTextNombre(JTextField textNombre) {
        this.textNombre = textNombre;
    }

    public JTextField getTextApellidos() {
        return textApellidos;
    }

    public void setTextApellidos(JTextField textApellidos) {
        this.textApellidos = textApellidos;
    }

    public JTextField getTextFechaNacimiento() {
        return textFechaNacimiento;
    }

    public void setTextFechaNacimiento(JTextField textFechaNacimiento) {
        this.textFechaNacimiento = textFechaNacimiento;
    }

    public JTextField getTextTelefono() {
        return textTelefono;
    }

    public void setTextTelefono(JTextField textTelefono) {
        this.textTelefono = textTelefono;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(JTextField textEmail) {
        this.textEmail = textEmail;
    }
}
