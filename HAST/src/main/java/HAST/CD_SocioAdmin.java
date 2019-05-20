package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CD_SocioAdmin {
    private JPanel panel;
    private JButton anadirButtonSocio;
    private JButton editarButtonSocio;
    private JButton cancelarButtonSocio;
    private JTextArea textSocios;

    public CD_SocioAdmin(JFrame frame) {


        anadirButtonSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Socios");
                frame.setContentPane(new CDA_AnadirSocios(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        editarButtonSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Editar socio");
                frame.setContentPane(new CDB_EditarSocio(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        cancelarButtonSocio.addActionListener(new ActionListener() {
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

        anadirButtonSocio = new JButton((new ImageIcon("plus.png")));
        editarButtonSocio = new JButton((new ImageIcon("edit.png")));
        cancelarButtonSocio = new JButton((new ImageIcon("exit.png")));
    }
}
