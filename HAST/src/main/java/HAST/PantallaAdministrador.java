package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaAdministrador {
    public JPanel panel;
    private JButton buttonActividades;
    private JButton buttonJunta;
    private JButton buttonCuotas;
    private JButton buttonSocios;
    private JButton buttonCalendario;




    public PantallaAdministrador() {
        buttonActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actividades");
                frame.setContentPane(new PanelActividadesAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }


        });


        buttonCuotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Editar Cuotas");
                frame.setContentPane(new CuotasAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        buttonSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Socios");
                frame.setContentPane(new SocioAdmin(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        buttonCalendario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonJunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Editar Junta");
                frame.setContentPane(new JuntaAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });


    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonActividades = new JButton(new ImageIcon("actividades.png") {

        });

        buttonJunta = new JButton((new ImageIcon("junta.png")));
        buttonCuotas = new JButton(new ImageIcon("cuota.png"));
        buttonCalendario = new JButton(new ImageIcon("calendario.png"));
        buttonSocios = new JButton(new ImageIcon("socios.png"));

    }
}
