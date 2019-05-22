package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCA_AnadirCuotaAdm {
    private JPanel panel;
    private JTextField textPrecio;
    private JButton ButtonGuardarCuotaAdm;
    private JButton buttonCancelarCuotaAdm;
    private JTextField textanyadi;

    public JPanel getPanel() {
        return panel;
    }

    public CCA_AnadirCuotaAdm(JFrame frame) {
        buttonCancelarCuotaAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });


        ButtonGuardarCuotaAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonCancelarCuotaAdm = new JButton((new ImageIcon("cancel2.png")));
        ButtonGuardarCuotaAdm = new JButton((new ImageIcon("save.png")));




    }
}
