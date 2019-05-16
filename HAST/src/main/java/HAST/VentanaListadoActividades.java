package HAST;

import javax.swing.*;

public class VentanaListadoActividades {
    private JPanel Principal;
    private JPanel panelDerecho;
    private JButton buttonAnterior;
    private JButton button1sig;
    private JPanel panelizquierdo;
    private JPanel PanelMedio;


    public JPanel getPrincipal() {
        return Principal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Listado de actividades");
        frame.setContentPane(new VentanaListadoActividades().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
