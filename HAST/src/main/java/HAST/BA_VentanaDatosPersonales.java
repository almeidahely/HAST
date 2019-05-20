package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BA_VentanaDatosPersonales {
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
    private JButton cancelarButtonDatos;
    private JButton aceptarButtonDatos;
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

    public BA_VentanaDatosPersonales(JFrame frame) {

        aceptarButtonDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancelarButtonDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
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

