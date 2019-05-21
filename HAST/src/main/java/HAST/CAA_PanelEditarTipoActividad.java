package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CAA_PanelEditarTipoActividad {
    public JPanel panel;
    private JComboBox selectorActividad;
    private JButton guardarButtonTipoActividad;
    private JButton buttonCancelarTipoActividad;
    private JTextField textNombreActividad;

    private List<String> actividades = new ArrayList<>();

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
