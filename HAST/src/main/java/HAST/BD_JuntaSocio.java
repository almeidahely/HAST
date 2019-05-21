package HAST;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;

import static HAST.AccionesBD.socios;

public class BD_JuntaSocio {
    public JPanel panel1;
    private JTable tabla;



    public BD_JuntaSocio() {

        tabla.setModel(new ModeloTablaJunta(AccionesBD.socios,AccionesBD.cargos));

        tabla.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("BD_JuntaSocio");
        frame.setContentPane(new BD_JuntaSocio().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code

    }

}

