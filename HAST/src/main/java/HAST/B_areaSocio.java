package HAST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B_areaSocio extends Container {
    public JPanel socioPanel;
    private JButton laJuntaButton;
    private JButton verCalendarioButton;
    private JButton actividadesButton;
    private JButton datosPersonalesButton;
    private JPanel Panel;
    private JLabel usuarioEntrada;

    public JPanel getSocioPanel() {
        return socioPanel;
    }
    String nombreUsuario,apellidoUsuario;
    public B_areaSocio() {


        
        usuarioEntrada.setText("Vienvenid@ "+nombreUsuario+" "+ apellidoUsuario);
        datosPersonalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Socio");
                frame.setContentPane(new BA_VentanaDatosPersonales(frame).Principal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        actividadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Listado de actividades");
                frame.setContentPane(new CAA_PanelEditarTipoActividad(frame).panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        verCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("");
                frame.setContentPane(new BC_Calendario().getPanelCalendario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        laJuntaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("La junta");
                frame.setContentPane(new BD_JuntaSocio().panel1);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


}