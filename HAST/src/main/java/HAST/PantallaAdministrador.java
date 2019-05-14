package HAST;

import javax.swing.*;

public class PantallaAdministrador {
    private JPanel panel;
    private JButton actividadesButton;
    private JButton buttonJunta;
    private JButton buttonCuotas;
    private JButton buttonSocios;
    private JButton buttonCalendario;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PantallaAdministrador");
        frame.setContentPane(new PantallaAdministrador().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
