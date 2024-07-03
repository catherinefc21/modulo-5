package service;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase de servicio para manejar las operaciones relacionadas con los usuarios.
 * Proporciona métodos para verificar las credenciales de los usuarios, realizar retiros y depósitos,
 * y obtener el saldo de un usuario. Utiliza {@link ConexionBD} para establecer conexiones con la base de datos.
 */
public class UserService {

    private ConexionBD conexionBD;

    /**
     * Constructor para inicializar la conexión a la base de datos.
     */
    public UserService() {
        this.conexionBD = new ConexionBD();
    }

    /**
     * Verifica las credenciales de un usuario.
     *
     * @param email El email del usuario.
     * @param password La contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
    public boolean verificarUsuario(String email, String password) {
        Connection connection = conexionBD.establecerConexion();
        if (connection == null) {
            System.out.println("Connection failed");
            return false;
        }
        String sql = "SELECT * FROM Usuario WHERE email = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Realiza un retiro de la cuenta de un usuario.
     *
     * @param email El email del usuario.
     * @param monto El monto a retirar.
     */
    public void realizarRetiro(String email, double monto) {
        try (Connection connection = conexionBD.establecerConexion()) {
            String sql = "UPDATE Usuario SET saldo = saldo - ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, monto);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el saldo actual de la cuenta de un usuario.
     *
     * @param email El email del usuario.
     * @return El saldo de la cuenta del usuario.
     */
    public double obtenerSaldo(String email) {
        double saldo = 0;
        try (Connection connection = conexionBD.establecerConexion()) {
            String sql = "SELECT saldo FROM Usuario WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                saldo = resultSet.getDouble("saldo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saldo;
    }

    /**
     * Realiza un depósito en la cuenta de un usuario.
     *
     * @param email El email del usuario.
     * @param monto El monto a depositar.
     */
    public void realizarDeposito(String email, double monto) {
        try (Connection connection = conexionBD.establecerConexion()) {
            String sql = "UPDATE Usuario SET saldo = saldo + ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, monto);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}