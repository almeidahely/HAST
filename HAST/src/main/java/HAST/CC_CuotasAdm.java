package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CC_CuotasAdm {
    private JPanel panel;
    private JButton buttonAnadirCuota;
    private JButton buttonEditarCuota;
    private JButton buttonVerCuota;
    private JButton buttonCancelarCuota;

    public CC_CuotasAdm(JFrame frame) {
        buttonCancelarCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonAnadirCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Añadir Cuota");
                frame.setContentPane(new CCA_AnadirCuotaAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        buttonEditarCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Editar cuota");
                frame.setContentPane(new CCB_EditarCuota(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        buttonVerCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ver cuotas");
                frame.setContentPane(new CCC_VerCuotasAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        buttonAnadirCuota = new JButton((new ImageIcon("plus.png")));
        buttonEditarCuota = new JButton((new ImageIcon("edit.png")));
        buttonVerCuota = new JButton((new ImageIcon("eye.png")));
        buttonCancelarCuota = new JButton((new ImageIcon("exit.png")));
    }
}
