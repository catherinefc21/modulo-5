package service;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private ConexionBD conexionBD;

    public UserService() {
        this.conexionBD = new ConexionBD();
    }

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
