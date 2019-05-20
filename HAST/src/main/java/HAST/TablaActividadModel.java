


package HAST;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaActividadModel extends AbstractTableModel {

    private String[] columnas = {"codigoActividad", "descripción", "precio", "organizador", "fechaActividad"};
    private List<Actividad> listaActividades;

    public TablaActividadModel() {

        listaActividades = BaseDatosActividad.listarActividades();
    }



    @Override
    public int getRowCount() {
        return listaActividades.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad a = listaActividades.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getCodigoActividad();
            case 1:
                return a.getDescripcion();
            case 2:
                return a.getPrecio();
            case 3:
                return a.getOrganizador();

            case 4:
                return a.getFechaActividad();

        }

        return null;
    }
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}


