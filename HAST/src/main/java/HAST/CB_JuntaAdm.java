package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CB_JuntaAdm {
    private JPanel panel;
    private JComboBox selectorSocio;
    private JComboBox SelectorCargo;
    private JButton buttonAnadirJunta;
    private JButton buttonEliminarJunta;
    private JButton buttonEditarJunta;
    private JButton buttonCancelarJunta;

    public JPanel getPanel() {
        return panel;
    }

    public CB_JuntaAdm(JFrame frame) {
        buttonAnadirJunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonEditarJunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        buttonEliminarJunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        buttonCancelarJunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();


            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        buttonAnadirJunta = new JButton((new ImageIcon("plus.png")));
        buttonEditarJunta = new JButton((new ImageIcon("edit.png")));
        buttonEliminarJunta = new JButton((new ImageIcon("remove.png")));
        buttonCancelarJunta = new JButton((new ImageIcon("exit.png")));
    }
}
