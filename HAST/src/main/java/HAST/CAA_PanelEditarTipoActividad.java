package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAA_PanelEditarTipoActividad {
    public JPanel panel;
    private JComboBox selectorTipo;
    private JComboBox selectorDificultad;
    private JButton guardarButton;
    private JButton buttonCancelar;

    public CAA_PanelEditarTipoActividad(JFrame frame) {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
