package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

                Connection conexion = BD.getConn();

                String insertarDatosSql = "INSERT INTO DBUSER (nombre, apellido, DNI, telefono, email, perfil) VALUES (?,?,?,?,?,?)";


                try {

                    PreparedStatement anyadirSocio = conexion.prepareStatement(insertarDatosSql);
                    anyadirSocio.setString(1, textNombre.getText());
                    anyadirSocio.setString(2, textApellidos.getText());
                    anyadirSocio.setString(3, textDNI.getText());
                    anyadirSocio.setString(4, textTelefono.getText());
                    anyadirSocio.setString(5, textEmail.getText());
                    anyadirSocio.setString(6, selectorPerfil.getModel().toString());


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
