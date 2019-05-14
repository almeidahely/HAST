package HAST;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {

    public static Connection conexion() {

        // Conectar a la base de datos
        System.out.println("--- Conexión a Oracle --------------------------");

        Connection conn = null;
        try {
            // Cargar el driver Oracle JDBC Thin (ojdbc7.jar)
            // REF: Descarga: http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            // Cadena de conexión: driver@machineName:port:SID, userid, password
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "egibide", "egibide");
            System.out.println("INFO: Conexión abierta");

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("------------------------------------------------");

        return conn;
    }

}
