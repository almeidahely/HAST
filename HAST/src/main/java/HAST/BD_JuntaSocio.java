package HAST;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static HAST.AccionesBD.socios;

public class BD_JuntaSocio {
    public JPanel panel1;
    private JTable tabla;
    private JComboBox comboBox1;


    public BD_JuntaSocio() {
        List<Junta> juntas =new ArrayList<>();
        juntas.addAll(AccionesBD.listaSociosJunta.values());


        /// apartir de aqui es lo que tenias cambialo y dejalo como actividades
        tabla.setModel(new ModeloTablaJunta(AccionesBD.MapMAyoresDeEdad, AccionesBD.cargos));

        tabla.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }



    private void createUIComponents() {
        // TODO: place custom component creation code

    }

}

