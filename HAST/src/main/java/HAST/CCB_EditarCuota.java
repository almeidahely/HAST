package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCB_EditarCuota {
    private JPanel panel;
    private JComboBox selectorCuota;
    private JComboBox selectorPorcentaje;
    private JButton buttonEliminarCuotaAdm;
    private JButton buttonSubirCuota;
    private JButton buttonBajarCuota;
    private JButton buttonCancelarCuotaAdm;

    public CCB_EditarCuota(JFrame frame) {
        buttonCancelarCuotaAdm.addActionListener(new ActionListener() {
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

        buttonBajarCuota = new JButton((new ImageIcon("minus.png")));
        buttonSubirCuota = new JButton((new ImageIcon("plus.png")));
        buttonEliminarCuotaAdm = new JButton((new ImageIcon("remove.png")));
        buttonCancelarCuotaAdm = new JButton((new ImageIcon("exit.png")));
    }
}
