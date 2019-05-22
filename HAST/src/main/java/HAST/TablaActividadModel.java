


package HAST;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaActividadModel extends AbstractTableModel {

    private String[] columnas = {"codigoActividad", "descripción", "precio", "organizador", "dificultad", "fechaActividad"};




    public TablaActividadModel() {
        System.out.println(AccionesBD.listaActividades.size());
    }


    @Override
    public int getRowCount() {
        return AccionesBD.listaActividades.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad a = AccionesBD.listaActividades.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getCodigoActividad();
            case 1:
                return a.getDescripcion();
            case 2:
                return a.getPrecio();
            case 3:
                return a.getOrganizador().getCodigoSocio();

            case 4:
                return a.getDificultad();

            case 5:
                return a.getTipo();
            case 6:
                return a.getFechaActividad();

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}


