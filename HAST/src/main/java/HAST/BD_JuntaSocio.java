package HAST;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BD_JuntaSocio {
    public JPanel panel1;
    private JTable table1;

    public BD_JuntaSocio() {
        table1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }



}

