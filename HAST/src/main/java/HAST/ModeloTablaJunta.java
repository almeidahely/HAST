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

    private String[]todos={"nombre", "apellido", "telefono", "email", "nombreCargo", "fechaInicio"};
    private Map<Integer, Cargo> cargos;
     private  List<Junta> cache = new ArrayList<>();
     private Map<Integer,Socio> soc;


    public ModeloTablaJunta(Map<Integer, Socio> socios, Map<Integer, Cargo> cargos) {
        this.cargos = cargos;
        this.getData();
        this.soc=socios;
    }

    private void getData(){

        try {

            Connection connection = BD.getConn();

            //LLamado del procedimiento
            //nombre de procedimiento//
            System.out.println("hola");
            String sql = "{ call LISTA_DATO(?) }";
            CallableStatement listjunta = connection.prepareCall(sql);
            //Parametros de entrada
            listjunta.registerOutParameter(1, OracleTypes.CURSOR);//recibe parametro de cursor
           listjunta.execute();

            //Se obtiene el cursor en forma de ResultSet
            ResultSet campo = (ResultSet) listjunta.getObject(1);
            while (campo.next()) {
                Junta junt = new Junta(campo.getInt("codigoSocio"),
                        campo.getInt("codigoCargo"),
                        campo.getString("fechaInicio"),
                        (campo.getString("fechaFin")),
                        campo.getInt("numAjuntado"));
                cache.add(junt);
            }
            campo.close();
            listjunta.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public int getRowCount() {
        return cache.size();
    }

    @Override
    public int getColumnCount() {
        return todos.length;
    }

    public String getColumnName(int col) {
        return todos[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (this.getColumnName(columnIndex)) {
            case "nombre":
                int codigoSocio = cache.get(rowIndex).getCodigoSocio();
                return this.soc.get(codigoSocio).getNombre();
            case "apellido":
                codigoSocio = cache.get(rowIndex).getCodigoSocio();
                return this.soc.get(codigoSocio).getApellido();
            case "telefono":
                 codigoSocio = cache.get(rowIndex).getCodigoSocio();
                return this.soc.get(codigoSocio).getTelefono();
            case "email":
                 codigoSocio = cache.get(rowIndex).getCodigoSocio();
                return this.soc.get(codigoSocio).getEmail();
            case "nombreCargo":
                int codigoCargo = cache.get(rowIndex).getCodigoCargo();
                return this.cargos.get(codigoCargo).getNombreCargo();
            case "fechaInicio":
                return cache.get(rowIndex).getFechaInicio();
            default:
                return null;
        }
    }

}












