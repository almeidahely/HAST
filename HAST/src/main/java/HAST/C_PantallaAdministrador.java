package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class C_PantallaAdministrador {
    public JPanel panel;
    private JButton buttonActividades;
    private JButton buttonJunta;
    private JButton buttonCuotas;
    private JButton buttonSocios;
    private JButton buttonCalendario;
    private JButton SalirButtonAdm;


    public C_PantallaAdministrador(JFrame frame) {
        buttonActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actividades");
                frame.setContentPane(new CA_PanelActividadesAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }


        });

        buttonJunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Junta");
                frame.setContentPane(new CB_JuntaAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });


        buttonCuotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Editar Cuotas");
                frame.setContentPane(new CC_CuotasAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        buttonSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Socios");
                frame.setContentPane(new CD_SocioAdmin(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        buttonCalendario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Generar calendario");
                frame.setContentPane(new CE_GenerarCalendarioAdm(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }
        });


        SalirButtonAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonActividades = new JButton(new ImageIcon("actividadesAdmin.png") {

        });

        buttonJunta = new JButton((new ImageIcon("laJunta.png")));
        buttonCuotas = new JButton(new ImageIcon("dinero.png"));
        buttonCalendario = new JButton(new ImageIcon("calendar.png"));
        buttonSocios = new JButton(new ImageIcon("sociosAdmin.png"));
        SalirButtonAdm = new JButton(new ImageIcon("exit2.png"));

    }


    // Borrar

}
