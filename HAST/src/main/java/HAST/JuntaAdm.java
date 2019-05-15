package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuntaAdm {
    private JPanel panel;
    private JComboBox selectorSocio;
    private JComboBox SelectorCargo;
    private JButton buttonAnadir;
    private JButton buttonEliminar;
    private JButton buttonEditar;
    private JButton buttonCancelar;

    public JPanel getPanel() {
        return panel;
    }

    public JuntaAdm(JFrame frame) {
        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        buttonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        buttonEliminar.addActionListener(new ActionListener() {
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
}
