package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CDA_AnadirSocios {
    private JPanel panel;
    private JComboBox selectorPerfil;
    private JComboBox selectorResponsable;
    private JButton buttonCancelar;
    private JButton buttonAnadir;
    private JTextField textDNI;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textFechaNacimiento;
    private JTextField textTelefono;
    private JTextField textEmail;

    public CDA_AnadirSocios(JFrame frame) {
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
