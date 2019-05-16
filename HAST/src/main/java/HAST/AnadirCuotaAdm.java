package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnadirCuotaAdm {
    private JPanel panel;
    private JComboBox selectorEdad;
    private JTextField textPrecio;
    private JButton guardarButton;
    private JButton cancelarButton;

    public JPanel getPanel() {
        return panel;
    }

    public AnadirCuotaAdm(JFrame frame) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
