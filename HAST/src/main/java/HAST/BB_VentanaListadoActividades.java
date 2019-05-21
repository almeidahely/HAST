package HAST;

import javax.swing.*;

public class BB_VentanaListadoActividades {
    private JPanel Principal;
    private JPanel PanelMedio;
    private JTable tableActividad;
    private JComboBox comboBox1;


    // codigoActividad      number
    // tipo                 varchar2
    // descripcion          varchar2
    // difiultad            varchar2
    // precio               number
    // cancelado            varchar2 notNull
    // organizador          number notNull
    // fechaActividad       date


    public BB_VentanaListadoActividades(JFrame frame) {
        tableActividad.setModel(new TablaActividadModel());

    }

    public JPanel getPrincipal() {
        return Principal;
    }


}
