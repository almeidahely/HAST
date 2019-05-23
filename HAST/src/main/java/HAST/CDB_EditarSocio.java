package HAST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

            }
        });
        eliminarSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                textFechaNaci.setText(todoSocio.get(usuario).getFechaNacimiento());
                labelFechaAlta.setText(todoSocio.get(usuario).getFechaAlta());
                int mayor = 0;
                    for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                        if (socio.getCodigoSocio() == todoSocio.get(usuario).getCodigoSocio()) {
                            mayor = 1;
                        }
                        }




                if(mayor==0){
                    for (Socio socio : AccionesBD.listaSocioMayorDeEdad) {
                        selectorResponsable.addItem(socio.getCodigoSocio()+"- "+ socio.getNombre());
                    }
                }
            }
        });

    }
}
