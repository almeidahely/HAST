package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerCuotasAdm {
    private JPanel panel;
    private JButton cerrarButton;

    public JPanel getPanel() {
        return panel;
    }

    public VerCuotasAdm(JFrame frame) {
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
    }
}
