package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDatosPersonales {
    public JPanel Principal;
    private JPanel SegundoPanel;
    private JPanel panelIzquierdoSuperior;
    private JPanel PanelDerechoSuperior;
    private JPanel panelIzInferior;
    private JPanel PanelDerechoInferior;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton imagenButton;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JLabel nombreLabel;
    private JLabel telefonoLabel;
    private JLabel emailLabel;
    private JLabel fechaNacimientoLabel;
    private JLabel DNINIELabel;
    private JLabel sociDesdeLabel;
    private JLabel responsableDeLabel;
    private JLabel LabelNUMERODNI;
    private JLabel labelFechaAlta;
    private JLabel labelNumResponsab;

    public JPanel getPrincipal() {
        return Principal;
    }

    public VentanaDatosPersonales() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanel() {
        return Principal;
    }





}

