package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerarCalendarioAdm {
    private JPanel panel;
    private JComboBox selectorDia;
    private JComboBox selectorActividad;
    private JButton buttonGuardar;
    private JButton buttonCancelar;

    public GenerarCalendarioAdm(JFrame frame) {
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
