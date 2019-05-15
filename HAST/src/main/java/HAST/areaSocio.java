package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class areaSocio {
    private JPanel socioPanel;
    private JButton laJuntaButton;
    private JButton verCalendarioButton;
    private JButton actividadesButton;
    private JButton datosPersonalesButton;
    private JPanel Panel;
    private JLabel usuarioEntrada;

    public areaSocio() {
        datosPersonalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Socio");
                frame.setContentPane(new Calendario().getCalendario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        actividadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Listado de actividades");
                frame.setContentPane(new Calendario().getCalendario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        verCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("");
                frame.setContentPane(new Calendario().getCalendario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        laJuntaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("La junta");
                frame.setContentPane(new Calendario().getCalendario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        usuarioEntrada.setText("Bienvenido" + " aqui insertamos nombre en la misma variable porque hay un margen cabron");
    }
}