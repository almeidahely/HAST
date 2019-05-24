package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BB_VentanaListadoActividades {
    public JPanel Principal;
    private JPanel PanelMedio;
    private JTable tableActividad;
    private JButton pagarYApuntarseButton;


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

        pagarYApuntarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // No inserta datos. Pero falta poco.
                    Connection conexion = BD.getConn();
                    String insertarUsuario = "INSERT INTO PARTICIPANTE(codigoSocio,pagoActividad) values(?,?)";

                    PreparedStatement pstmt = conexion.prepareStatement(insertarUsuario);


                    /*
                    String query = "SELECT * FROM ACTIVIDAD";
                    String muery = "SELECT * FROM SOCIO";

                    Statement st = conexion.createStatement();

                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
                    ResultSet sr = st.executeQuery(muery);


                    // iterate through the java resultset
                    while (rs.next())
                    {
                        //int codigoActividad = rs.getInt("codigoActividad");
                        int codigoSocio = sr.getInt("codigoSocio");
                        int pagoActividad = rs.getInt("precio");

                    PreparedStatement pstmt = conexion.prepareStatement(insertarUsuario);

                    //pstmt.setInt(1, 4);
                    pstmt.setInt(1, 101);
                    pstmt.setInt(2, 123);
                    pstmt.execute();
*/
                } catch (SQLException ee) { //Siempre realiza Exception
                    System.out.println("No ha sido añadido ");
                }
            }
        });
    }

    public JPanel getPrincipal() {
        return Principal;
    }


}
