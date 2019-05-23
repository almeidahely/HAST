package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class CCA_AnadirCuotaAdm {
    private JPanel panel;
    private JTextField textanyadi;
    private JTextField textPrecio;
    private JButton ButtonGuardarCuotaAdm;
    private JButton buttonCancelarCuotaAdm;

    public JPanel getPanel() {
        return panel;
    }

    public CCA_AnadirCuotaAdm(JFrame frame) {
        buttonCancelarCuotaAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });
        ButtonGuardarCuotaAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // obtener el campo de la edad

                // obtener el precio insertado en el campo de texto, y convertir a numero

                // llamada la funcion para insertar


                //static void añadirCuotasNuevo ( Int,String apellido,String DNI, String telefono,    String email, String fechaDeNacimiento){
                Connection conexion = BD.getConn();

                try {
                    String cuota= "{call CrearNuevaCuota(?,?)}";

                    CallableStatement añadido =conexion.prepareCall(cuota);
                    añadido.setString(1,textanyadi.getText());
                    añadido.setDouble(2,Double.parseDouble(textPrecio.getText().toString()));


                   añadido.execute();
                      JOptionPane.showMessageDialog(null,"Guardado");





                } catch (SQLException ee) {
                    System.out.println("no añadido ");
                }





                System.out.println("pulsado boton guardar");
            }

        });

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonCancelarCuotaAdm = new JButton((new ImageIcon("cancel2.png")));
        ButtonGuardarCuotaAdm = new JButton((new ImageIcon("save.png")));




    }
}


