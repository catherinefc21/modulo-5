package controller;

import model.Usuario;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controlador para gestionar las solicitudes de depósito.
 * Este servlet maneja las peticiones POST para realizar depósitos en la cuenta de un usuario.
 */
@WebServlet("/deposito")
public class DepositoController extends HttpServlet {

    private UserService usuarioService = new UserService();

    /**
     * Maneja la solicitud POST para realizar un depósito.
     * Este método recupera el email del usuario y el monto del depósito desde la solicitud,
     * luego utiliza el servicio de usuario para realizar el depósito y redirige al usuario a la página de inicio.
     *
     * @param request La solicitud HTTP que contiene el email del usuario y el monto a depositar.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error específico del servlet.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        double monto = Double.parseDouble(request.getParameter("monto"));

        usuarioService.realizarDeposito(email, monto);

        response.sendRedirect("index.jsp");
    }
}