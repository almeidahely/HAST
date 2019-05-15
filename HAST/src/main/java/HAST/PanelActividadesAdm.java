package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelActividadesAdm {
    private JPanel panel;
    private JTextField textNombre;
    private JButton añadirButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton cancelarButton;


    public PanelActividadesAdm(JFrame frame) {
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Editar Tipo actividad");
                frame.setContentPane(new PanelEditarTipoActividad().getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
