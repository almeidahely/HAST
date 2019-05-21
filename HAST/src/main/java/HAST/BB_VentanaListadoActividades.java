package HAST;

import javax.swing.*;

public class BB_VentanaListadoActividades {
    private JPanel Principal;
    private JPanel panelDerecho;
    private JButton buttonAnterior;
    private JButton button1sig;
    private JPanel panelizquierdo;
    private JPanel PanelMedio;


    // codigoActividad      number
    // tipo                 varchar2
    // descripcion          varchar2
    // difiultad            varchar2
    // precio               number
    // cancelado            varchar2 notNull
    // organizador          number notNull
    // fechaActividad       date


    public BB_VentanaListadoActividades(JFrame frame) {
    }

    public JPanel getPrincipal() {
        return Principal;
    }


}
