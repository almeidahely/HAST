package HAST;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Junta {
    private Socio codigoSocio;
    private Cargo codigoCargo;
    private String fechaInicio;
    private String fechaFin;
    private int numAjuntado;

    public Junta(Socio codigoSocio, Cargo codigoCargo, String fechaInicio, String fechaFin, int numAjuntado) {
        this.codigoSocio = codigoSocio;
        this.codigoCargo = codigoCargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numAjuntado = numAjuntado;
        List<Junta>juntaList=new ArrayList<>();

    }

    static void MostrarJunta() {

        try {

            Connection connection = BD.getConn();

            //LLamado del procedimiento
            //nombre de procedimiento//
            String sql = "begin LISTA_DATO(?); end;";
            CallableStatement listjunta = connection.prepareCall(sql);

            //Parametros de entrada
            listjunta.registerOutParameter(1, OracleTypes.CURSOR);//recibe parametro de cursor

            listjunta.execute();

            //Se obtiene el cursor en forma de ResultSet
            ResultSet campo = (ResultSet) listjunta.getObject(1);
            while (campo.next()) {

               // Junta junt  = new Junta(campo.getString("nombre"),campo.getString("apellido"),campo.getString("telefono"),campo.getString("email"),campo.getString("nombreCargo"),campo.getDate("fechaInicio"));

                System.out.println("Nombre:");
                //System.out.println(rs.getLong("CODIGO"));
                System.out.println(campo.getString("nombre"));
                System.out.println("Apellido:");
                System.out.println(campo.getString("apellido"));
                System.out.println("Telefono:");
                System.out.println(campo.getString("telefono"));
                System.out.println("Email:");
                System.out.println(campo.getString("email"));
                System.out.println("Nombre Cargo:");
                System.out.println(campo.getString("nombreCargo"));
                System.out.println("Fecha Inicio:");
                System.out.println(campo.getDate("fechaInicio"));

            }
            campo.close();
            listjunta.close();
            connection.close();

        } catch (SQLException e) {
            //Imprime el mensaje de la exception lanzada en pl/sql si el valor es diferente de 1
            e.printStackTrace();
        }
    }




}
