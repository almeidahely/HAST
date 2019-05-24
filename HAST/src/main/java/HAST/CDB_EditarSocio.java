package HAST;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CDB_EditarSocio {
    private JPanel panel;
    private JTextField textDNI;
    private JComboBox comboBox1;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textFechaNaci;
    private JTextField textTelefono;
    private JTextField textEmail;
    private JComboBox selectorResponsable;
    private JButton cancelarButton;
    private JButton guardarButton;
    private JButton eliminarSocioButton;
    private JLabel labelFechaAlta;
    private JButton actualizarButton;
    private DatePicker PickerFechaNac;
    private JButton buttonCancelar;
    private JButton buttonGuardar;
    private JButton buttonEliminar;

    public JPanel getPanel() {
        return panel;
    }


    public CDB_EditarSocio(JFrame frame) {
        List<Socio> todoSocio = new ArrayList<>();
        todoSocio.addAll(AccionesBD.socios.values());
        for (Socio socio : todoSocio) {
            comboBox1.addItem(socio.getCodigoSocio());
        }


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection conexion = BD.getConn();
                int usuario = comboBox1.getSelectedIndex();
                int mayor = 0;
                for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                    if (socio.getCodigoSocio() == todoSocio.get(usuario).getCodigoSocio()) {
                        mayor = 1;
                    }
                }
                try {
                    if (mayor == 1) {
                        PreparedStatement editar = conexion.prepareStatement("UPDATE SOCIO set nombre=?,apellido=?,DNI=?,telefono=?,email=?,fechaNacimiento=? where codigoSocio=?");
                        editar.setString(1, textNombre.getText());
                        editar.setString(2, textApellido.getText());
                        editar.setString(3, textDNI.getText());
                        editar.setString(4, textTelefono.getText());
                        editar.setString(5, textEmail.getText());


                        editar.setDate(6, Date.valueOf(PickerFechaNac.getDate()));

                        //editar.setDate(6, Date.valueOf((String.format(textFechaNaci.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))));


                        editar.setInt(7, todoSocio.get(usuario).getCodigoSocio());
                        System.out.println("28");

                        editar.executeLargeUpdate();


                        editar.close();



                        System.out.println("29");
                    } else {
                        PreparedStatement editarMenor = conexion.prepareStatement("UPDATE SOCIO set nombre=?,apellido=?,DNI=?,telefono=?,email=?,fechaNacimiento=?,codigoResponsable=? where codigoSocio=?");
                        editarMenor.setString(1, textNombre.getText());
                        editarMenor.setString(2, textApellido.getText());
                        editarMenor.setString(3, textDNI.getText());
                        editarMenor.setString(4, textTelefono.getText());
                        editarMenor.setString(5, textEmail.getText());

                        //PickerFechaNac.setDate(LocalDate.parse(todoSocio.get(usuario).getFechaNacimiento(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));


                        //editarMenor.setDate(6,Date.valueOf(PickerFechaNac.getDate()));

                        editarMenor.setDate(6, Date.valueOf((String.format(textFechaNaci.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))));


                        editarMenor.setInt(7, todoSocio.get(selectorResponsable.getSelectedIndex()).getCodigoSocio());
                        editarMenor.setInt(8, todoSocio.get(usuario).getCodigoSocio());
                        editarMenor.executeLargeUpdate();
                        editarMenor.close();
                    }


                    // - - - - -







                    //------------------



                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });
        eliminarSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usuario = comboBox1.getSelectedIndex();
                int mayor = 0;
                for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                    if (socio.getCodigoSocio() == todoSocio.get(usuario).getCodigoSocio()) {
                        mayor = 1;
                    }
                }
                Connection conexion = BD.getConn();


            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectorResponsable.removeAllItems();
                int usuario = comboBox1.getSelectedIndex();
                System.out.println(usuario);
                textNombre.setText(todoSocio.get(usuario).getNombre());
                textApellido.setText(todoSocio.get(usuario).getApellido());
                textDNI.setText(todoSocio.get(usuario).getDNI());
                textEmail.setText(todoSocio.get(usuario).getEmail());
                textTelefono.setText(todoSocio.get(usuario).getTelefono());

                PickerFechaNac.setDate(LocalDate.parse(todoSocio.get(usuario).getFechaNacimiento(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));


                //textFechaNaci.setText(todoSocio.get(usuario).getFechaNacimiento());


                labelFechaAlta.setText(todoSocio.get(usuario).getFechaAlta());
                int mayor = 0;
                for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                    if (socio.getCodigoSocio() == todoSocio.get(usuario).getCodigoSocio()) {
                        mayor = 1;
                    }
                }


                if (mayor == 0) {
                    for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                        selectorResponsable.addItem(socio.getCodigoSocio() + "- " + socio.getNombre());
                    }
                }



            }


        });

    }
}
