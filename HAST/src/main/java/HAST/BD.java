package HAST;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {

    public static Connection getConn() {
        if(conn == null) {
            conexion();
        }

        return conn;
    }

    private static Connection conn;

    public static Connection conexion() {

        // Conectar a la base de datos
        System.out.println("--- Conexión a Oracle --------------------------");

         conn = null;
        try {
            // Cargar el driver Oracle JDBC Thin (ojdbc7.jar)
            // REF: Descarga: http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            // Cadena de conexión: driver@machineName:port:SID, userid, password
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "egibide", "egibide");
            //El de abajo Hely
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.101:1521:xe", "egibide", "egibide");

            System.out.println("INFO: Conexión abierta");

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("------------------------------------------------");

        return conn;
    }


}
