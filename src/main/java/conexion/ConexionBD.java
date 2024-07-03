package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos de AlkeWallet.
 * Utiliza el patrón Singleton para asegurar una única instancia de la conexión.
 */
public class ConexionBD {
    private String url = "jdbc:mysql://localhost:3306/alkewalletdb"; // URL de conexión a la base de datos
    private String usuario = "root"; // Usuario de la base de datos
    private String pass = ""; // Contraseña del usuario de la base de datos

    /**
     * Establece una conexión con la base de datos.
     *
     * @return Una instancia de {@link Connection} si la conexión es exitosa, null en caso contrario.
     */
    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el driver de MySQL
            return DriverManager.getConnection(url, usuario, pass); // Establece la conexión con la base de datos
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Imprime el stack trace en caso de error
            return null; // Retorna null si no se pudo establecer la conexión
        }
    }
}