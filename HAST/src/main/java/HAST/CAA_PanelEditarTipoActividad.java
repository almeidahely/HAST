package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAA_PanelEditarTipoActividad {
    public JPanel panel;
    private JComboBox selectorTipo;
    private JComboBox selectorDificultad;
    private JButton guardarButtonTipoActividad;
    private JButton buttonCancelarTipoActividad;

    public CAA_PanelEditarTipoActividad(JFrame frame) {
        guardarButtonTipoActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonCancelarTipoActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        guardarButtonTipoActividad = new JButton((new ImageIcon("save.png")));
        buttonCancelarTipoActividad = new JButton(new ImageIcon("cancel2.png"));
    }
}
