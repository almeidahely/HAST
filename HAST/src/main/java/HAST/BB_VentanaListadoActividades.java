package HAST;

import javax.swing.*;

public class BB_VentanaListadoActividades {
    private JPanel Principal;
    private JPanel PanelMedio;
    private JTable tableActividad;
    private JComboBox comboBox1;

    public BB_VentanaListadoActividades(JFrame frame) {
        tableActividad.setModel(new TablaActividadModel());

    }

    public JPanel getPrincipal() {
        return Principal;
    }


}
