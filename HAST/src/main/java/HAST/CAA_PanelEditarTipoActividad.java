package HAST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CAA_PanelEditarTipoActividad {
    public JPanel panel;
    private JComboBox selectorActividad;
    private JButton guardarButtonTipoActividad;
    private JButton buttonCancelarTipoActividad;
    private JTextField textNombreActividad;

    private List<String> actividades = new ArrayList<>();

    public CAA_PanelEditarTipoActividad(JFrame frame) {
        selectorActividad.removeAllItems();
        Connection conexion = BD.getConn();
        try {
            Statement sttipo = conexion.createStatement();

            ResultSet rs = sttipo.executeQuery("Select*from tipoActividad");
            while (rs.next()) {
                selectorActividad.addItem(rs.getString("nombre"));

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        guardarButtonTipoActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //*----------

                try {
                    Connection conexion = BD.getConn();
                    String insertarTipoActividad = "UPDATE tipoActividad set nombre = ?";

                    PreparedStatement pstmt = null;


                    String nombre = null;
                    try {
                        nombre = textNombreActividad.getText();
                    } catch (Exception ex) {
                    }


                    pstmt = conexion.prepareStatement(insertarTipoActividad);

                    pstmt.setString(1, nombre);

                    pstmt.executeUpdate();

                    textNombreActividad.setText("");

                    JOptionPane.showMessageDialog(null, "OK", "Actualizado", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    //System.out.println("Error al insertar el dato");
                }


                //


            }
        });
        buttonCancelarTipoActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        guardarButtonTipoActividad = new JButton((new ImageIcon("save.png")));
        buttonCancelarTipoActividad = new JButton(new ImageIcon("cancel2.png"));
    }
}
