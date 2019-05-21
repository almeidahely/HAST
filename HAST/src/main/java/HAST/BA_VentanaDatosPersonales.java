package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;

public class BA_VentanaDatosPersonales {
    public JPanel Principal;
    private JPanel SegundoPanel;
    private JPanel panelIzquierdoSuperior;
    private JPanel PanelDerechoSuperior;
    private JPanel panelIzInferior;
    private JPanel PanelDerechoInferior;
    private JTextField textNombre;
    private JTextField textTelefono;
    private JTextField textEmail;
    private JTextField textFechaNacimiento;
    private JButton imagenButton;
    private JButton cancelarButtonDatos;
    private JButton aceptarButtonDatos;
    private JLabel nombreLabel;
    private JLabel telefonoLabel;
    private JLabel emailLabel;
    private JLabel fechaNacimientoLabel;
    private JLabel DNINIELabel;
    private JLabel sociDesdeLabel;
    private JLabel responsableDeLabel;
    private JLabel labelDNI;
    private JLabel labelFechaAlta;
    private JLabel labelNumResponsab;

    public JPanel getPrincipal() {
        return Principal;
    }

    public BA_VentanaDatosPersonales(JFrame frame) {

        aceptarButtonDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection conexion = BD.getConn();

                try {
                    //actualizar datos telefono / email

                    PreparedStatement stmt = conexion.prepareStatement("UPDATE SOCIO set telefono = ? where codigoSocio = ?");

                    String nuevoTelefono = textTelefono.getText();
                    stmt.setString(1, nuevoTelefono);
                    stmt.setInt(2, A_PantallaPrincipal.getSocioUsuario());

                    stmt.executeUpdate();

                    PreparedStatement stmt2 = conexion.prepareStatement("UPDATE SOCIO set email = ? where codigoSocio = ?");
                    stmt2.setString(1, textEmail.getText());
                    stmt2.setInt(2, A_PantallaPrincipal.getSocioUsuario());

                    stmt2.executeUpdate();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


                frame.dispose();


            }
        });

        cancelarButtonDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


            Connection conexion = BD.getConn();

            try {
                Statement stmt = conexion.createStatement();


                PreparedStatement Pstmt = conexion.prepareStatement("select * from Socio where codigoSocio = ?");
                Pstmt.setInt(1, A_PantallaPrincipal.getSocioUsuario());


                ResultSet datosUser = Pstmt.executeQuery();


            while (datosUser.next()) {
                datosUser.getString("nombre");
                datosUser.getString("telefono");
                datosUser.getString("email");
                datosUser.getString("fechaNacimiento");
                datosUser.getString("DNI");
                datosUser.getString("fechaAlta");
                datosUser.getString("fechaBaja");
                datosUser.getString("codigoResponsable");


                textNombre.setText(datosUser.getString("nombre"));
                textTelefono.setText(datosUser.getString("telefono"));
                textEmail.setText(datosUser.getString("email"));
                textFechaNacimiento.setText(datosUser.getString("fechaNacimiento"));




                labelDNI.setText(datosUser.getString("DNI"));
                labelFechaAlta.setText(datosUser.getString("fechaAlta"));

                String codigoResponsable = datosUser.getString("codigoResponsable");


                if (codigoResponsable == null) {
                    labelNumResponsab.setVisible(false);
                    responsableDeLabel.setVisible(false);
                } else {
                    labelNumResponsab.setText(datosUser.getString("codigoResponsable"));

                }


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public JPanel getPanel() {
        return Principal;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        imagenButton = new JButton((new ImageIcon("avatar.png")));
        aceptarButtonDatos = new JButton(new ImageIcon("save.png"));
        cancelarButtonDatos = new JButton(new ImageIcon("cancel2.png"));


    }
}

