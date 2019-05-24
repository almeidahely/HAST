package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class CA_PanelActividadesAdm {
    private JPanel panel;
    private JTextField textNombre;
    private JButton añadirButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private JComboBox comboBox1nomActiv;
    private JComboBox comboBoxnombreActiv;

    String idcontacto = "";


    public CA_PanelActividadesAdm(JFrame frame) {
        //insertar combobox de base de datos
        comboBox1nomActiv.removeAllItems();
        Connection conexion = BD.getConn();
        try {
            Statement sttipo = conexion.createStatement();

            ResultSet rs = sttipo.executeQuery("Select*from tipoActividad");
            while (rs.next()) {
                comboBox1nomActiv.addItem(rs.getString("nombre"));

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Editar Tipo actividad");
                frame.setContentPane(new CAA_PanelEditarTipoActividad(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                cargarComboActividades();


            }


        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoElemento = textNombre.getText();
                int viejoElemento = comboBox1nomActiv.getItemCount();
                boolean existe = false;
                for (int i = 0; i < viejoElemento; i++) {
                    if (comboBox1nomActiv.getItemAt(i).equals(nuevoElemento)) {
                        existe = true;

                    }
                }
                if (!existe) {
                    comboBox1nomActiv.addItem(nuevoElemento);
                    comboBox1nomActiv.repaint();

                    // ------------------------------


                    try {
                        Connection conexion = BD.getConn();
                        String insertarTipoActividad = "INSERT INTO tipoActividad(nombre) values(?)";

                        PreparedStatement pstmt = null;

                        String nombre = textNombre.getText();


                        //


                        //fechaAlta


                        pstmt = conexion.prepareStatement(insertarTipoActividad);

                        pstmt.setString(1, nombre);

                        //fecha de alta


                        pstmt.executeUpdate();


                    } catch (SQLException ex) {
                        //System.out.println("Error al insertar el dato");
                    }


                    // -------------------------------------


                    JOptionPane.showMessageDialog(null, "Se ha anadido !!!!");

                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe ese tipo de actividad");
                }

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AccionesBD.Eliminar_Actividad(comboBox1nomActiv.getSelectedItem().toString());
                cargarComboActividades();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();


            }
        });
    }

    private void cargarComboActividades() {
        comboBox1nomActiv.removeAllItems();
        Connection conexion = BD.getConn();

        try {
            Statement sttipo = conexion.createStatement();

            ResultSet rs = sttipo.executeQuery("Select*from tipoActividad");
            while (rs.next()) {
                comboBox1nomActiv.addItem(rs.getString("nombre"));

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        añadirButton = new JButton((new ImageIcon("plus.png")));
        editarButton = new JButton((new ImageIcon("edit.png")));
        eliminarButton = new JButton((new ImageIcon("remove.png")));
        cancelarButton = new JButton((new ImageIcon("exit.png")));

    }
}
