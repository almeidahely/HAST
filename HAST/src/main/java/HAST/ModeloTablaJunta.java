package HAST;

import oracle.jdbc.OracleTypes;

import javax.swing.table.AbstractTableModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class ModeloTablaJunta extends AbstractTableModel {

    private List<Junta> juntas;

    private String[] todos = {"Nombre", "Apellido", "Telefono", "Email", "FechaInicio", "NombreCargo"};

    public ModeloTablaJunta() {

        juntas = new ArrayList<>();
        juntas.addAll(AccionesBD.listaSociosJunta.values());

    }


    @Override
    public int getRowCount() {
        return juntas.size();
    }

    @Override
    public int getColumnCount() {
        return todos.length;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Junta j=juntas.get(rowIndex);

        switch (columnIndex) {
            case 1:
                return j.getCodigoSocio().getNombre();
            case 2:
                return j.getCodigoSocio().getApellido();
            case 3:
                return j.getCodigoSocio().getTelefono();
            case 4:
                return j.getCodigoSocio().getEmail();

            case 0:
               return j.getCodigoCargo().getNombreCargo();

        }


        return null;
    }

    @Override
    public String getColumnName(int column) {
        return todos[column];
    }

}














