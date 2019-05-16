package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accesoAdmin {
    private JPanel panel;
    private JPanel adminPanel;
    private JButton botonSocio;
    private JButton botonAdmin;

    public JPanel getPanel() {
        return panel;
    }

    public accesoAdmin() {
        botonSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Área de socio");
                frame.setContentPane(new areaSocio().socioPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Editar");
                frame.setContentPane(new PantallaAdministrador().panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quieres acceder como");
        frame.setContentPane(new accesoAdmin().adminPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
   
}
