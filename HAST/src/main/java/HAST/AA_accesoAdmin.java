package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AA_accesoAdmin {
    private JPanel panel;
    private JPanel adminPanel;
    private JButton botonSocio;
    private JButton botonAdmin;

    public JPanel getPanel() {
        return panel;
    }

    public AA_accesoAdmin() {
        botonSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Área de socio");
                frame.setContentPane(new B_areaSocio().socioPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Editar");
                frame.setContentPane(new C_PantallaAdministrador().panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


   
}
