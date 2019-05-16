package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarCuota {
    private JPanel panel;
    private JComboBox selectorCuota;
    private JComboBox selectorPorcentaje;
    private JButton eliminarButton;
    private JButton subirButton;
    private JButton bajarButton;
    private JButton cancelarButton;

    public EditarCuota(JFrame frame) {
        cancelarButton.addActionListener(new ActionListener() {
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
