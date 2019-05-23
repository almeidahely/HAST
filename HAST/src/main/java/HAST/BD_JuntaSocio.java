package HAST;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static HAST.AccionesBD.listaSociosJunta;
import static HAST.AccionesBD.socios;

public class BD_JuntaSocio {
    public JPanel panel1;
    private JTable tabla;


    public JPanel getPanel1() {
        return panel1;
    }

    public BD_JuntaSocio() {

      //  tabla.setModel(new ModeloTablaJunta(AccionesBD.MapMAyoresDeEdad, AccionesBD.cargos));
        AccionesBD.TodosLosSocios();
        AccionesBD.RellenarListaCargos();
        AccionesBD.RellenarListaJunta();
        tabla.setModel(new ModeloTablaJunta());





    }

}

