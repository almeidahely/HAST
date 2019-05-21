package HAST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CA_PanelActividadesAdm {
    private JPanel panel;
    private JTextField textNombre;
    private JButton añadirButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton cancelarButton;

    String idcontacto="";


    public CA_PanelActividadesAdm(JFrame frame) {
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Editar Tipo actividad");
                frame.setContentPane(new CAA_PanelEditarTipoActividad(frame).getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idcontacto.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el nombre a eliminar","Error en la opercion",JOptionPane.ERROR_MESSAGE);

                }else {
                    AccionesBD.Eliminar_Actividad(idcontacto);
                }

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();


            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        añadirButton = new JButton((new ImageIcon("plus.png")));
        editarButton = new JButton((new ImageIcon("edit.png")));
        eliminarButton = new JButton((new ImageIcon("remove.png")));
        cancelarButton = new JButton((new ImageIcon("exit.png")));

    }
}
