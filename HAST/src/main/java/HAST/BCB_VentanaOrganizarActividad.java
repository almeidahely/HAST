package HAST;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class BCB_VentanaOrganizarActividad {
    public JPanel Principal;
    private JPanel PanelEntero;
    private JPanel PanelInferior;
    private JPanel panelSuperior;
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel PanelMedio;
    private JTextField textFieldPrecio;
    public JLabel fechaActividad;
    private JComboBox comboBoxDificultad;
    private JComboBox comboBoxTipo;
    private JPanel paneldeDescripcion;
    private JLabel descripcionLabel;
    private JTextField textFieldDescripcion;


    public JPanel getPrincipal() {

        return Principal;
    }

    public BCB_VentanaOrganizarActividad(LocalDate seleccion) {

        fechaActividad.setText(seleccion.toString());


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                // Ahora como lo meto a la propia base de datos para que guarde?

               /*  Ejemplo prueba

                String value1 = String.valueOf(comboBoxDificultad.getSelectedIndex());
                String value2 = String.valueOf(comboBoxTipo.getSelectedIndex());
                Double value3 = Double.valueOf(textFieldPrecio.getText());
                String value4 = textFieldDescripcion.getText();
                String value5 = "no";
                Date value7 =Date.valueOf(fechaActividad.getText());


                System.out.println(value1 + value2 + value3 + value4 + value5);
                try {
                    String anadirActiv= "{call CrearNuevaActiv(?,?,?,?,?,?,?)}";

                    CallableStatement st = conexion.prepareCall(anadirActiv);
                    st.setString(1, value1);
                    st.setString(2, value2);
                    st.setDouble(3, value3);
                    st.setString(4, value4);
                    st.setString(5, value5);
                    st.setDouble(6,A_PantallaPrincipal.socioUsuario);
                    st.setDate(7,value7);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data is successfully inserted into database.");
                    conexion.close();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(null,"Error in submitting data!");
                }
            }
        });*/


                try {
                    Connection conexion2 = BD.getConn();
                    String insertarUsuario = "INSERT INTO ACTIVIDAD(tipo,descripcion,dificultad,precio,cancelado,organizador,fechaActividad) values(?,?,?,?,?,?,?)";

                    String tipo = String.valueOf(comboBoxTipo.getSelectedItem());
                    String descri = textFieldDescripcion.getText();
                    String difi = String.valueOf(comboBoxDificultad.getSelectedItem());
                    String precio = textFieldPrecio.getText();
                    int nuevoPrecio = Integer.parseInt(precio);
                    String cancelado = "activo";

                   // int value4 = Integer.parseInt(String.valueOf(textFieldPrecio));
                    // int codigoUser = A_PantallaPrincipal.codigoUsuarioConectdo.get(0);
                    // int nuevoco = codigoUser;

                    Date fecha =Date.valueOf(fechaActividad.getText());

                    PreparedStatement pstmt = conexion2.prepareStatement(insertarUsuario);

                    pstmt.setString(1, tipo);
                    pstmt.setString(2, descri);
                    pstmt.setString(3, difi);
                    pstmt.setInt(4, nuevoPrecio);
                    pstmt.setString(5, cancelado);
                    pstmt.setInt(6, 101); // falta que meta el user automatico
                    pstmt.setDate(7, fecha);
                    pstmt.execute();


                    /*String anadirActiv = "INSERT INTO SOCIO(nombre,apellido,DNI,telefono,email,perfil,fechaAlta,fechaNacimiento) values(?,?,?,?,?,?,?,?)";
                    //Objects.requireNonNull(comboBoxDificultad.getSelectedItem()).toString())
                    PreStatement anadido = conexion.prepareCall(anadirActiv);
                    anadido.setDouble(1, 105);
                    anadido.setString(2, (String)comboBoxTipo.getSelectedItem());
                    anadido.setString(3, textFieldDescripcion.getText());
                    anadido.setString(4, (String)comboBoxDificultad.getSelectedItem());
                    anadido.setInt(5, Integer.parseInt(textFieldPrecio.getText()));
                    anadido.setString(6, "activo");
                    anadido.setInt(7, 101);
                    anadido.setDate(8, Date.valueOf(fechaActividad.getText()));
                    anadido.execute();

                    System.out.println("Hecho");*/

                } catch (SQLException ee) { //Siempre realiza Exception
                    System.out.println("No ha sido añadido ");
                }
                fechaActividad.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {

                    }
                });
            }
        });
    }
}