package HAST;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class JuntaSocio {
    public JPanel panel1;
    private JTable table1;

    public JuntaSocio() {
        table1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JuntaSocio");
        frame.setContentPane(new JuntaSocio().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

