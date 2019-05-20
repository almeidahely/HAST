package HAST;

import javax.swing.*;

public class BB_VentanaListadoActividades {
    private JPanel Principal;
    private JPanel PanelMedio;
    private JTable tableActividad;
    private JComboBox comboBox1;

    public BB_VentanaListadoActividades(JFrame frame) {
    }

    public JPanel getPrincipal() {
        return Principal;
    }


    private void createUIComponents() {

        // TODO: place custom component creation code here
        tableActividad=new JTable();
        tableActividad.setModel(new TablaActividadModel());

    }
}
