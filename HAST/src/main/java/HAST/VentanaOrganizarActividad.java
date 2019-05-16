package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOrganizarActividad {
    private JPanel Principal;
    private JPanel PanelEntero;
    private JPanel PanelInferior;
    private JPanel panelSuperior;
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel PanelMedio;
    private JTextField textFieldPrecio;
    private JTextField textFieldTitulo;
    private JLabel labe2lREspFecha;
    private JComboBox comboBoxDificultad;
    private JComboBox comboBoxTipo;
    private JPanel paneldeDescripcion;
    private JLabel descripciónLabel;
    private JTextField textFieldDescripcion;



    public JPanel getPrincipal() {

        return Principal;
    }

    public VentanaOrganizarActividad() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
