package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuotasAdm {
    private JPanel panel;
    private JButton buttonAnadir;
    private JButton buttonEditar;
    private JButton buttonEliminar;
    private JButton buttonCancelar;

    public CuotasAdm(JFrame frame) {
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Añadir Cuota");
                frame.setContentPane(new AnadirCuotaAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
