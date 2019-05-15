package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEditarTipoActividad {
    private JPanel panel;
    private JComboBox selectorTipo;
    private JComboBox selectorDificultad;
    private JButton guardarButton;

    public PanelEditarTipoActividad() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
