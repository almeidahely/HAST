package HAST;

import javax.swing.*;import java.awt.event.MouseAdapter;

public class CBA_editarCargo {
    private JPanel panelillo;
    private JComboBox BarraCodiSocio;
    private JButton guardarButton;

    public CBA_editarCargo() { BarraCodiSocio.addMouseListener(new MouseAdapter() { } );}public static void main(String[] args) {
        JFrame frame = new JFrame("CBA_editarCargo");
        frame.setContentPane(new CBA_editarCargo().panelillo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
