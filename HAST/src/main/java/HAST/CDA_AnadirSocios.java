package HAST;

import com.github.lgooddatepicker.components.DatePicker;

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
    //private JButton buttonCancelar;
    private JButton buttonAnadirSocioCDA;
    private JTextField textDNI;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textFechaNacimiento;
    private JTextField textTelefono;
    private JTextField textEmail;
    private DatePicker selectorFecha;
    private JLabel labelResponsable;
    private JButton F5;
    private JButton buttonCancelarAddSocio;
    private JLabel labelError;
    private JLabel labelPerfil;

    static List<Socio> litaSocios = new ArrayList<>();


    public CDA_AnadirSocios(JFrame frame) {

        labelError.setVisible(false);


        if (selectorPerfil.getSelectedItem().toString().equalsIgnoreCase("administrador")) {
            labelResponsable.setEnabled(false);
            selectorResponsable.setEnabled(false);
        } else {
            labelResponsable.setEnabled(true);
            selectorResponsable.setEnabled(true);
        }


        buttonCancelarAddSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });


        buttonAnadirSocioCDA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //  --------------------------------------------


                try {
                    Connection conexion = BD.getConn();
                    String insertarUsuario = "INSERT INTO SOCIO(nombre,apellido,DNI,telefono,email,perfil,fechaAlta,fechaNacimiento) values(?,?,?,?,?,?,?,?)";

                    PreparedStatement pstmt = null;

                    String nombre = textNombre.getText();
                    String apellido = textApellidos.getText();
                    String DNI = textDNI.getText();
                    // CODIGO SOCIO. no hay que añadir el codigoSocio la base de datos lo puede autoincrementar utilizando un trigger
                    String telefono = textTelefono.getText();
                    String email = textEmail.getText();
                    String perfil = (String) selectorPerfil.getSelectedItem();

                    //


                    //fechaAlta
                    java.util.Date date = new java.util.Date();
                    long t = date.getTime();
                    java.sql.Date sqlDate = new java.sql.Date(t);


                    pstmt = conexion.prepareStatement(insertarUsuario);

                    pstmt.setString(1, nombre);
                    pstmt.setString(2, apellido);
                    pstmt.setString(3, DNI);
                    pstmt.setString(4, telefono);
                    pstmt.setString(5, email);
                    pstmt.setString(6, perfil);

                    //fecha de alta
                    pstmt.setDate(7, sqlDate);


                    if (selectorFecha.getDate() == null) {
                        labelError.setText("Error, en la fecha de nacimiento");
                        labelError.setVisible(true);
                    } else {
                        labelError.setVisible(false);
                        pstmt.setDate(8, Date.valueOf(selectorFecha.getDate()));


                    }


                    pstmt.executeUpdate();
                    //System.out.println("Socio añadido");


                    labelError.setText("Usuario añadido correctamente");
                    labelError.setVisible(true);

                    textNombre.setText("");
                    textApellidos.setText("");
                    textDNI.setText("");
                    textTelefono.setText("");
                    textEmail.setText("");
                    LocalDate fechaHoy = LocalDate.now();
                    selectorFecha.setDate(fechaHoy);


                } catch (SQLException ex) {
                    labelError.setText("Error, rellena los campos correctamente.");
                    labelError.setVisible(true);
                    //System.out.println("Error al insertar el dato");
                }


                // -----------------------------------------


            }
        });


        //botón para actualizar perfil

        F5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                labelError.setVisible(false);

                if (selectorPerfil.getSelectedItem().toString().equalsIgnoreCase("administrador")) {
                    labelResponsable.setEnabled(false);
                    selectorResponsable.setEnabled(false);
                } else {
                    labelResponsable.setEnabled(true);
                    selectorResponsable.setEnabled(true);
                }
            }
        });
    }


    public JPanel getPanel() {
        return panel;
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
        return buttonCancelarAddSocio;
    }

    public void setButtonCancelar(JButton buttonCancelar) {
        this.buttonCancelarAddSocio = buttonCancelar;
    }

    public JButton getButtonAnadirSocioCDA() {
        return buttonAnadirSocioCDA;
    }

    public void setButtonAnadirSocioCDA(JButton buttonAnadirSocioCDA) {
        this.buttonAnadirSocioCDA = buttonAnadirSocioCDA;
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        F5 = new JButton((new ImageIcon("update.png")));
        buttonAnadirSocioCDA = new JButton((new ImageIcon("plus.png")));
        buttonCancelarAddSocio = new JButton((new ImageIcon("exit.png")));

    }
}
